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

	/**
	 * The vertex's ID for map use.
	 */
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
	public CourseModel(String subject, int number, String name, String prerequisites, String concurrentEnrollment,
			String description, String enrollmentInfo, int vertexIndex) {
		this.subject = subject;
		this.number = number;
		this.name = name;
		this.description = description;
		this.enrollmentInfo = enrollmentInfo;
		this.vertexIndex = vertexIndex;
		this.update(prerequisites, concurrentEnrollment);
	}

	/**
	 * Returns the course's course subject. (CS, HIS, MAT)
	 * 
	 * @return a String that represents the course subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Returns the course's course number
	 * 
	 * @return an integer that represents the course number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Returns the course's vertex ID, which could be used for maps
	 * 
	 * @return an integer that is a vertex ID
	 */
	public int getNum() {
		return vertexIndex;
	}

	/**
	 * Returns a String of the course's name (Introduction to Programming I)
	 * 
	 * @return a String of the course's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns a String of the enrollment information for the course which
	 * includes the prerequisites and concurrent courses
	 * 
	 * @return a String of the course's enrollment information
	 */
	public String getEnrollmentInfo() {
		return enrollmentInfo;
	}

	/**
	 * Returns a String of the course's description
	 * 
	 * @return a String of the course's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the course's name which is the subject and number (HIS 2123, CS
	 * 1173)
	 * 
	 * @return a String that contains the subject and course numbers
	 */
	public String getSubjectNumber() {
		return subject + " " + number;
	}

	/**
	 * Returns a String of the full length course name which includes subject,
	 * number, and name. (EXAMPLE: CS 3333 Math Foundations of CS)
	 * 
	 * @return a String of the course's subject, number, and name
	 */
	public String getFullName() {
		return subject + " " + number + " " + name;
	}

	/**
	 * Takes in two Strings and splits them into two ArrayLists for the course's
	 * prerequisites and concurrent courses
	 * 
	 * @param pre
	 *            a String of prerequisite courses
	 * @param con
	 *            a String of concurrent courses
	 */
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

	/**
	 * Returns the course's prerequisites
	 * 
	 * @return an ArrayList of Strings that contains a list of the course's
	 *         prerequisites
	 */
	public ArrayList<String> getPrerequisiteList() {
		return prerequisiteList;
	}

	/**
	 * Returns the course's concurrent enrollments
	 * 
	 * @return an ArrayList of Strings containing a list of the course's
	 *         concurrent enrollments
	 */
	public ArrayList<String> getConcurrentList() {
		return concurrentList;
	}

	/**
	 * Returns the course's information as a String. This includes subject,
	 * course number, course name, a list of the course's prerequisites, a list
	 * of the course's concurrent courses list, the enrollment information, and
	 * a description of the course. All of which is reformatted using new lines.
	 */
	@Override
	public String toString() {
		return subject + " " + number + "\n" + name + "\n\nPrerequisites: " + prerequisiteList.toString()
				+ "\n\nConcurrent: " + concurrentList.toString() + "\n\nEnroll Info: " + enrollmentInfo
				+ "\n\nDescription: " + description + "\n";
	}
}
