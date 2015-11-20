package flowguimodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class GraphModel {

	/**
	 * 
	 */
	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>(); // will
																					// store
																					// the
																					// 'master'
																					// CourseModel
																					// arraylist

	/**
	 * 
	 */
	private Map<String, CourseModel> listOfVertices = new LinkedHashMap<String, CourseModel>(); // this
																								// simply
																								// creates
																								// a
																								// hashed
																								// array
																								// (hash-map)
																								// of
																								// the
																								// above
																								// arraylist

	/**
	 * 
	 */
	private Set<DirectedEdgeModel> listOfEdges = new LinkedHashSet<DirectedEdgeModel>(); // stores
																							// the
																							// links
																							// between
																							// the
																							// courses
																							// in
																							// the
																							// above
																							// CourseModel
																							// arraylist

	/**
	 * 
	 * @param majorModel
	 * @throws Exception
	 */
	public GraphModel(MajorModel majorModel) throws Exception {
		this.listOfCourses = majorModel.getCourseModelList();
		generateVertices();
		generateEdges();
		// printVertices();
		// printEdges();
	}

	/**
	 * 
	 */
	private void generateVertices() {
		for (CourseModel c : listOfCourses) {
			listOfVertices.put(c.getSubjectNumber(), c);
		}
	}

	/**
	 * 
	 */
	private void generateEdges() {

		Iterator<CourseModel> it = listOfVertices.values().iterator();

		while (it.hasNext()) {
			CourseModel current = it.next(); // from the hash, get a course
			ArrayList<String> tempPrerequisiteList = current.getPrerequisiteList(); // for
																					// that
																					// course,
																					// save
																					// its
																					// prerequisite
																					// arraylist
			ArrayList<String> tempConcurrentList = current.getConcurrentList(); // for
																				// that
																				// course,
																				// save
																				// its
																				// concurrent
																				// arraylist
			String courseName; // we will be using this to index the hash-map
								// (and subsequently connect edges)

			if (tempPrerequisiteList != null) {
				for (int i = 0; i < tempPrerequisiteList.size(); i++) {
					courseName = tempPrerequisiteList.get(i);
					if (listOfVertices.containsKey(courseName)) {
						DirectedEdgeModel e = new DirectedEdgeModel(listOfVertices.get(courseName), current,
								listOfVertices.get(courseName).getNum(), current.getNum()); // create
																							// a
																							// link
																							// between
																							// a
																							// prereq
																							// and
																							// a
																							// course
																							// based
																							// on
																							// their
																							// relative
																							// index
																							// in
																							// the
																							// main
																							// CourseModel
																							// arraylist
						listOfEdges.add(e); // adds an 'Edge model' to the list.
											// used for drawing/connecting the
											// vertices in the graph. creates a
											// relation between two courses
					}
				}

			} else if (tempConcurrentList != null) { // the loop is the same as
														// the prereqs
				for (int i = 0; i < tempConcurrentList.size(); i++) {
					courseName = tempConcurrentList.get(i);

					if (listOfVertices.containsKey(courseName)) {
						DirectedEdgeModel e = new DirectedEdgeModel(listOfVertices.get(courseName), current,
								listOfVertices.get(courseName).getNum(), current.getNum());
						listOfEdges.add(e);
					}
				}
			} else {
				break;
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public Map<String, CourseModel> getVertices() {
		return listOfVertices;
	}

	/**
	 * 
	 * @return
	 */
	public Set<DirectedEdgeModel> getEdges() {
		return listOfEdges;
	}

	/**
	 * 
	 * @param course
	 * @return
	 */
	public CourseModel getVertexIndex(String course) {
		return listOfVertices.get(course);
	}

	/**
	 * 
	 * @param course
	 *            course that you need the model from
	 * @return a String that contains the course model for the selected course
	 */
	public String returnCourseModel(String course) {
		return listOfVertices.get(course).toString();
	}

	/**
	 * The methods below are for troubleshooting/printing
	 */
	public void printEdges() {
		Iterator<DirectedEdgeModel> it = listOfEdges.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}

	/**
	 * Prints out the vertices to the console
	 */
	public void printVertices() {
		Iterator<CourseModel> it = listOfVertices.values().iterator();
		while (it.hasNext()) {
			CourseModel current = it.next();
			System.out.println(current.getNum() + " " + current.getSubjectNumber() + " Pre: "
					+ current.getPrerequisiteList().toString() + " Con: " + current.getConcurrentList().toString());
		}
	}
}