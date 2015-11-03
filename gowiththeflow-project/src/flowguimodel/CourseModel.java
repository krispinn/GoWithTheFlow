package flowguimodel;

import java.util.ArrayList;

/**
 * This class contains all the information for a single course which will be
 * used to create nodes on the flowchart.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
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

	private int vertexIndex;

	/**
	 * Contains the course's prerequisites.
	 */
	private ArrayList<String> prerequisiteList = new ArrayList<String>();

	/**
	 * Contains the course's concurrent enrollment courses.
	 */
	private ArrayList<String> concurrentList = new ArrayList<String>();

	/**
	 * The original line of text containing the prerequisites, concurrent
	 * enrollment courses, and other information.
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
	 * @param number
	 *            the course number
	 * @param name
	 *            the course name
	 * @param prerequisiteCourses
	 *            a list of the prerequisites
	 * @param concurrentCourses
	 *            a list of concurrent enrollment courses
	 * @param description
	 *            a description of the course
	 * @param enrollmentInfo
	 *            the original line containing enrollment info
	 */
	public CourseModel(String subject, int number, String name, String prerequisites,
			String concurrentEnrollment, String description, String enrollmentInfo, int vertexIndex) {
		this.subject = subject;
		this.number = number;
		this.name = name;
		this.description = description;
		this.enrollmentInfo = enrollmentInfo;
		this.vertexIndex = vertexIndex;
		this.update(prerequisites, concurrentEnrollment);
	}

	/**
	 * This method layouts the level of the course.. the more children, the
	 * higher the course will be on tree. i.e. Upper Division electives will be
	 * at the bottom as they have the least courses following them.
	 * 
	 * @param courses
	 *            - this should be the starting (or end, depending on design
	 *            choice) course
	 * @return
	 */

	public String getSubject() {
		return subject;
	}

	public int getNumber() {
		return number;
	}

	public int getNum() {
		return vertexIndex;
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

	public String getSubjectNumber() {
		return subject + " " + number;
	}
	
	public String getFullName() {
		return subject + " " + number + " " + name;
	}

	public void update(String pre, String con) {
		String tokens[] = pre.split(" ");
		if (tokens.length >= 3) {
			for (int i = 1; i < tokens.length - 1; i += 2) {
				prerequisiteList.add(tokens[i] + " " + tokens[i + 1]);
			}

		}
		tokens = con.split(" ");
		if (tokens.length >= 3) {
			for (int i = 1; i < tokens.length - 1; i += 2) {
				concurrentList.add(tokens[i] + " " + tokens[i + 1]);
			}
		}

	}

	public ArrayList<String> getPrerequisiteList() {
		return prerequisiteList;
	}

	public ArrayList<String> getConcurrentList() {
		return concurrentList;
	}

	@Override
	public String toString() {
		return subject + " " + number + "\n" + name + "\n\nPrerequisites: " + prerequisiteList.toString()
				+ "\n\nConcurrent: " + concurrentList.toString() + "\n\nEnroll Info: "
				+ enrollmentInfo + "\n\nDescription: " + description + "\n";
	}
}
