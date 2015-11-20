package flowguimodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class takes in a majorModel then generates a list of courses based on
 * the major given. Generates a map of vertices for each course as well as a map
 * for the edges connecting the vertices together using prerequisites and
 * concurrent courses.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class GraphModel {

	/**
	 * Stores the 'master' CourseModel ArrayList
	 */
	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>();

	/**
	 * A hashed array (hash-map) of the listOfCourses ArrayList
	 */
	private Map<String, CourseModel> listOfVertices = new LinkedHashMap<String, CourseModel>();

	/**
	 * Stores the links between the courses in the above CourseModel ArrayList
	 */
	private Set<DirectedEdgeModel> listOfEdges = new LinkedHashSet<DirectedEdgeModel>();

	/**
	 * Takes the passed in Major and generates a list of courses based on the
	 * major. Then generates the vertices and edges for that list of courses.
	 * 
	 * @param majorModel
	 *            the Major that the courses are taken from
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
	 * Generates a new vertex value into the Map for every CourseModel in
	 * listOfCourses
	 */
	private void generateVertices() {
		for (CourseModel c : listOfCourses) {
			listOfVertices.put(c.getSubjectNumber(), c);
		}
	}

	/**
	 * Goes through each course and makes edge connections between the courses
	 * via the prerequisites as well as making edges for any concurrently
	 * enrolled classes
	 */
	private void generateEdges() {

		Iterator<CourseModel> it = listOfVertices.values().iterator();

		while (it.hasNext()) {

			// from the hash, get a course
			CourseModel current = it.next();

			// for that course, save its prerequisite ArrayList
			ArrayList<String> tempPrerequisiteList = current.getPrerequisiteList();

			// for that course, save its concurrent ArrayList
			ArrayList<String> tempConcurrentList = current.getConcurrentList();

			/*
			 * We will be using this to index the hash-map (and subsequently
			 * connect edges)
			 */
			String courseName;

			if (tempPrerequisiteList != null) {
				for (int i = 0; i < tempPrerequisiteList.size(); i++) {
					courseName = tempPrerequisiteList.get(i);
					if (listOfVertices.containsKey(courseName)) {

						/*
						 * Create a link between a prerequisite and a course
						 * based on their relative index in the main CourseModel
						 * ArrayList
						 */
						DirectedEdgeModel e = new DirectedEdgeModel(listOfVertices.get(courseName), current,
								listOfVertices.get(courseName).getNum(), current.getNum());

						/*
						 * Adds an 'Edge Model' to the list. Used for
						 * drawing/connecting the vertices in the graph. Creates
						 * a relation between two courses
						 */
						listOfEdges.add(e);

					}
				}

				// the loop is the same as the prerequisites
			} else if (tempConcurrentList != null) {
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
	 * Returns a Map that contains the listOfVertices for a graph
	 * 
	 * @return a Map of the list of vertices
	 */
	public Map<String, CourseModel> getVertices() {
		return listOfVertices;
	}

	/**
	 * Returns the list of edges for a graph to use
	 * 
	 * @return a DirectedEdgeModel that contains a list of edges
	 */
	public Set<DirectedEdgeModel> getEdges() {
		return listOfEdges;
	}

	/**
	 * Returns the CourseModel for the given course ID
	 * 
	 * @param course
	 *            the ID of the course that you want the CourseModel for
	 * @return a CourseModel for the passed in course
	 */
	public CourseModel getVertexIndex(String course) {
		return listOfVertices.get(course);
	}

	/**
	 * Returns the CourseModel ID value as a String
	 * 
	 * @param course
	 *            course that you need the model from
	 * @return a String that contains the course model for the selected course
	 */
	public String returnCourseModel(String course) {
		return listOfVertices.get(course).toString();
	}

	/**
	 * The methods below are for troubleshooting/printing the edges
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