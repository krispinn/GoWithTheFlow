package testdannybilal;

import java.util.ArrayList;

/**
 * This class contains all the information for a single course which will be used to create nodes on
 * the flowchart.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason Blig
 */
public class Course {

	/**
	 * The course subject (CS, MAT, etc).
	 */
	private String subject;

	/**
	 * The course number (1063, 3443, etc).
	 */
	private int number;

	/**
	 * The name of the course (Calculus II, Application Programming, etc).
	 */
	private String name;

	/**
	 * Contains the course's prerequisites.
	 */
	private ArrayList<String[]> prerequisite = new ArrayList<>();

	/**
	 * Contains the course's concurrent enrollment courses.
	 */
	private ArrayList<String[]> concurrent = new ArrayList<>();
	
	/**
	 * This number is initialized by a recursive algorithm which counts the number children for the course 
	 */
	
	private int offspring;

	/**
	 * The original line of text containing the prerequisites, concurrent enrollment courses, and
	 * other information.
	 */
	
	private String enrollmentInfo;

	/**
	 * The description of the course.
	 */
	private String description;

	/**
	 * The constructor initializes all the fields.
	 * 
	 * @param subject
	 *            the course subject
	 * @param courseNumber
	 *            the course number
	 * @param courseName
	 *            the course name
	 * @param prerequisiteCourses
	 *            a list of the prerequisites
	 * @param concurrentCourses
	 *            a list of concurrent enrollment courses
	 * @param courseDescription
	 *            a description of the course
	 * @param courseEnrollment
	 *            the original line containing enrollment info
	 */
	public Course(String subject, int courseNumber, String courseName, String prerequisiteCourses,
			String concurrentCourses, String courseDescription, String courseEnrollment) {
		this.subject = subject;
		this.number = courseNumber;
		this.name = courseName;
		this.prerequisite.add(prerequisiteCourses.split(" "));
		this.concurrent.add(concurrentCourses.split(" "));
		this.description = courseDescription;
		this.enrollmentInfo = courseEnrollment;
	}
	
	/**
	 * This method layouts the level of the course.. the more children, the higher the course
	 * will be on tree. i.e. Upper Division electives will be at the bottom as they have the least 
	 * courses following them.
	 * @param courses - this should be the starting (or end, depending on design choice) course
	 * @return
	 */
	private int dependencies(int courses){
		return 1 + dependencies(courses);
	}

	public String getSubject() {
		return subject;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public ArrayList<String[]> getPrerequisite() {
		return prerequisite;
	}

	public ArrayList<String[]> getConcurrent() {
		return concurrent;
	}

	public String getEnrollmentInfo() {
		return enrollmentInfo;
	}

	public String getDescription() {
		return description;
	}
	
	public int getOffspring(){
		return offspring;
	}

	public String getSubNum() {
		return subject + " " + number;
	}
	
	@Override
	public String toString() {
		return subject + " " + number + " " + name + " | Prerequisites: " + prerequisite
				+ " | Concurrent: " + concurrent + " | Offspring: " + offspring + " | Enroll Info: " + enrollmentInfo
				+ " | Description: " + description + "]\n";
	}
}
