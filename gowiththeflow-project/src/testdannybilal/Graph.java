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
		addEdge();
		printNodes();
	}
	
	private void generateNodes() {
		for (Course c : listOfCourses) {
			addCourse(c);
		}
	}
	
	private void addCourse(Course c) {
		nodes.put(c.getSubNum(), c);
	}
	
	private void addAbstractCourse(String courseName) {
		Course tempCourse = new Course(courseName);
	}
	
	private void addEdge() {
		Iterator<Course> it = nodes.values().iterator();
		while (it.hasNext()) {
			Course current = it.next();
			ArrayList<String> tempList = current.getPrerequisiteList();
			//System.out.println(temp)
			if (tempList == null) { 
				break;
			}
			
			for (int i = 0; i < tempList.size(); i++) {
				String courseName = i + " " + tempList.get(i);
				
				
				System.out.println(current.getName() + " PRE" + courseName);
				
			}
		}
	}

	public void printNodes() {
		Iterator<Course> it = nodes.values().iterator();
		while (it.hasNext()) {
			Course current = it.next();
			//System.out.println(current.getSubNum() + " Pre: " + current.getPrerequisiteListToString() + " Con: " + current.getConcurrentListToString());
		}
	}
	
}
