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
		//printNodes();
	}
	
	public void generateNodes() {

		for (Course c : listOfCourses) {
			addCourse(c);
		}
	}
	
	public void addCourse(Course c) {
		nodes.put(c.getSubNum(), c);
	}

	public void printNodes() {
		Iterator<Course> it = nodes.values().iterator();
		while (it.hasNext()) {
			Course current = it.next();
			System.out.println(current.getSubNum());
		}
	}
	
}
