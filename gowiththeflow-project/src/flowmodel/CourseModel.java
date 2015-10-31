package flowmodel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains all the information for a single course which will be used to create nodes on
 * the flowchart.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason Blig
 */
public class CourseModel {

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
	
	private String abstractCourseName;

	private boolean abstractFlag;
	
	private String prerequisite;
	
	private String concurrent;
	
	private int num;
	
	/**
	 * Contains the course's prerequisites.
	 */
	private ArrayList<String> prerequisiteList = new ArrayList<String>();

	/**
	 * Contains the course's concurrent enrollment courses.
	 */
	private ArrayList<String> concurrentList = new ArrayList<String>();
	
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
	public CourseModel(String subject, int courseNumber, String courseName, String prerequisiteCourses,
			String concurrentCourses, String courseDescription, String courseEnrollment, int num) {
		this.subject = subject;
		this.number = courseNumber;
		this.name = courseName;
		this.prerequisite = prerequisiteCourses;
		this.concurrent = concurrentCourses;
		this.description = courseDescription;
		this.enrollmentInfo = courseEnrollment;
		this.abstractFlag = false;
		this.num = num;
		addReqs();
	}
	
	public CourseModel(String fullName, int num) {
		this.abstractCourseName = fullName;
		this.abstractFlag = true;
		this.num = num;
	}
	
	/**
	 * This method layouts the level of the course.. the more children, the higher the course
	 * will be on tree. i.e. Upper Division electives will be at the bottom as they have the least 
	 * courses following them.
	 * @param courses - this should be the starting (or end, depending on design choice) course
	 * @return
	 */

	public String getSubject() {
		return subject;
	}

	public int getNumber() {
		return number;
	}

	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
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
		if (abstractFlag) {
			return abstractCourseName;
		} else {
			return subject + " " + number;
		}
	}
	
	public void addReqs() {
		String tokens[] = prerequisite.split(" ");
		if (tokens.length >= 3) {
			for (int i = 1; i < tokens.length-1; i += 2) {
				prerequisiteList.add(tokens[i] + " " + tokens[i+1]);
				//System.out.println("PRE " + prerequisiteList.get(prerequisiteList.size()-1));
			}
			
		}
		tokens = concurrent.split(" ");
		if (tokens.length >= 3) {
			for (int i = 1; i < tokens.length-1; i+= 2) {
				concurrentList.add(tokens[i] + " " + tokens[i+1]);
				//System.out.println("CON " + concurrentList.get(concurrentList.size()-1));
			}
		}
		

	}
	
	public ArrayList<String> getPrerequisiteList() {
		return prerequisiteList;
	}
	
	public ArrayList<String> getConcurrentList() {
		return concurrentList;
	}
	
	public String getPrerequisiteListToString() {
		return prerequisiteList.toString();
	}
	
	public String getConcurrentListToString() {
		return concurrentList.toString();
	}
	
	@Override
	public String toString() {
		return subject + " " + number + " " + name + " | Prerequisites: " + prerequisiteList.toString()
				+ " | Concurrent: " + concurrentList.toString() + " | Offspring: " + offspring + " | Enroll Info: " + enrollmentInfo
				+ " | Description: " + description + "]\n";
	}
}
