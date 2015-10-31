package flowguimodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GraphModel {

	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>();
	private Map<String, CourseModel> nodes = new LinkedHashMap<String, CourseModel>();
	private Set<DirectedEdgeModel> edges = new LinkedHashSet<DirectedEdgeModel>();

	public GraphModel(ArrayList<CourseModel> list) {
		listOfCourses = list;
		generateNodes();
		generateEdges();
		printNodes();
		//printEdges();
	}

	private void generateNodes() {
		for (CourseModel c : listOfCourses) {
			addCourse(c);
		}
	}

	private void addCourse(CourseModel c) {
		nodes.put(c.getSubNum(), c);
	}

	private void generateEdges() {
		Iterator<CourseModel> it = nodes.values().iterator();

		while (it.hasNext()) {
			CourseModel current = it.next();
			ArrayList<String> tempPrerequisiteList = current.getPrerequisiteList();
			ArrayList<String> tempConcurrentList = current.getConcurrentList();
			String courseName;

			if (tempPrerequisiteList != null) {
				for (int i = 0; i < tempPrerequisiteList.size(); i++) {
					courseName = tempPrerequisiteList.get(i);

					if (!nodes.containsKey(courseName)) {
						/*Course from = new Course(courseName, listOfCourses.size());
						listOfCourses.add(from);
						DirectedEdge e = new DirectedEdge(from, current, from.getNum(), current.getNum());
						edges.add(e);*/
					} else {
						DirectedEdgeModel e = new DirectedEdgeModel(nodes.get(courseName), current,
								nodes.get(courseName).getNum(), current.getNum());
						edges.add(e);
					}
				}

			} else if (tempConcurrentList != null) {
				for (int i = 0; i < tempConcurrentList.size(); i++) {
					courseName = tempConcurrentList.get(i);

					if (!nodes.containsKey(courseName)) {
						/*Course from = new Course(courseName, listOfCourses.size());
						listOfCourses.add(from);
						DirectedEdge e = new DirectedEdge(from, current, from.getNum(), current.getNum());
						edges.add(e);*/
					} else {
						DirectedEdgeModel e = new DirectedEdgeModel(nodes.get(courseName), current,
								nodes.get(courseName).getNum(), current.getNum());
						edges.add(e);
					}
				}
			} else {
				break;
			}
		}
	}

	public Map<String, CourseModel> getNodes() {
		return nodes;
	}

	public Set<DirectedEdgeModel> getEdges() {
		return edges;
	}

	public void printNodes() {
		Iterator<CourseModel> it = nodes.values().iterator();
		while (it.hasNext()) {
			CourseModel current = it.next();
			System.out.println(current.getNum() + " " + current.getSubNum() + " Pre: " + current.getPrerequisiteListToString() + " Con: "
					+ current.getConcurrentListToString());
		}
	}

	public void printEdges() {
		Iterator<DirectedEdgeModel> it = edges.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
	
	public String returnCourseModel(String course) {
		CourseModel courseModel = nodes.get(course);
		return courseModel.getDescription();
	}
}
