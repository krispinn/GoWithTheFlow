package testdannybilal;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

public class Graph {
	
	private ArrayList<Course> listOfCourses;
	private Map<String, Course> nodes = new LinkedHashMap<>();
	private Set<DirectedEdge> edges = new LinkedHashSet<>();
	
	public Graph(ArrayList<Course> list) {
		listOfCourses = list;
		generateNodes();
		generateEdges();
		printNodes();
		printEdges();
	}
	
	private void generateNodes() {
		for (Course c : listOfCourses) {
			addCourse(c);
		}
	}
	
	private void addCourse(Course c) {
		nodes.put(c.getSubNum(), c);
	}
	
	private void generateEdges() {
		Iterator<Course> it = nodes.values().iterator();
		
		while (it.hasNext()) {
			Course current = it.next();
			ArrayList<String> tempPrerequisiteList = current.getPrerequisiteList();
			ArrayList<String> tempConcurrentList = current.getConcurrentList();
			
			if (tempPrerequisiteList != null) {
				for (int i = 0; i < tempPrerequisiteList.size(); i++) {
					String courseName = tempPrerequisiteList.get(i);
					
					if(!nodes.containsKey(courseName)) {
						Course from = new Course(courseName);
						DirectedEdge e = new DirectedEdge(from, current);
						edges.add(e);
					} else {
						DirectedEdge e = new DirectedEdge(nodes.get(courseName), current);
						edges.add(e);
					}
				}
				
			} else if (tempConcurrentList != null) {
				
			} else {
				break;
			}
			
			
		}
	}

	public void printNodes() {
		Iterator<Course> it = nodes.values().iterator();
		while (it.hasNext()) {
			Course current = it.next();
			System.out.println(current.getSubNum() + " Pre: " + current.getPrerequisiteListToString() + " Con: " + current.getConcurrentListToString());
		}
	}
	
	public void printEdges() {
		Iterator<DirectedEdge> it = edges.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
