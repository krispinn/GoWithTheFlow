package gowiththeflow;

import java.util.ArrayList;

/**
 * @author zli781
 *
 */
public class Course {
	
	private String major;
	
	private int number; 
	
	private String name;
	
	private ArrayList<String[]> prerequisite;
	
	private ArrayList<String[]> concurrent;

	private String enrollmentInfo;
	
	private String description;

	
	
	/**
	 * 
	 */
	public Course(String major, int courseNumber, String courseName, String prerequisiteCourses, String concurrentCourses, String courseDescription, String courseEnrollment) {
		this.major = major;
		this.number = courseNumber;
		this.name = courseName;
		this.prerequisite.add(prerequisiteCourses.split(" "));
		this.concurrent.add(concurrentCourses.split(" "));
		this.description = courseDescription;
		this.enrollmentInfo = courseEnrollment;
	}	
}
