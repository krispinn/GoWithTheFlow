package flowguimodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GraphModel {

	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>();
	private Map<String, CourseModel> listOfVertices = new LinkedHashMap<String, CourseModel>();
	private Set<DirectedEdgeModel> listOfEdges = new LinkedHashSet<DirectedEdgeModel>();
	
	public GraphModel(MajorModel majorModel) throws Exception {
		
		this.listOfCourses = majorModel.getCourseModelList();
		generateVertices();
		generateEdges();
		//printVertices();
		printEdges();
	}

	private void generateVertices() {
		for (CourseModel c : listOfCourses) {
			listOfVertices.put(c.getSubjectNumber(), c);
		}
	}

	private void generateEdges() {
		Iterator<CourseModel> it = listOfVertices.values().iterator();

		while (it.hasNext()) {
			CourseModel current = it.next();
			ArrayList<String> tempPrerequisiteList = current.getPrerequisiteList();
			ArrayList<String> tempConcurrentList = current.getConcurrentList();
			String courseName;

			if (tempPrerequisiteList != null) {
				for (int i = 0; i < tempPrerequisiteList.size(); i++) {
					courseName = tempPrerequisiteList.get(i);

					if (listOfVertices.containsKey(courseName)) {
						DirectedEdgeModel e = new DirectedEdgeModel(listOfVertices.get(courseName), current,
								listOfVertices.get(courseName).getNum(), current.getNum());
						listOfEdges.add(e);
					}
				}

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
	
	public Map<String, CourseModel> getVertices() {
		return listOfVertices;
	}

	public Set<DirectedEdgeModel> getEdges() {
		return listOfEdges;
	}

	public void printVertices() {
		Iterator<CourseModel> it = listOfVertices.values().iterator();
		while (it.hasNext()) {
			CourseModel current = it.next();
			System.out.println(current.getNum() + " " + current.getSubjectNumber() + " Pre: " + current.getPrerequisiteList().toString() + " Con: "
					+ current.getConcurrentList().toString());
		}
	}

	public void printEdges() {
		Iterator<DirectedEdgeModel> it = listOfEdges.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	public CourseModel getVertexIndex(String course) {
		CourseModel courseModel = listOfVertices.get(course);
		return courseModel;
	}
	
	public String returnCourseModel(String course) {
		CourseModel courseModel = listOfVertices.get(course);
		return courseModel.toString();
	}
}
