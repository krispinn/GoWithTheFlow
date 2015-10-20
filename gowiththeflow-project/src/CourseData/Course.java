package CourseData;

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
}
