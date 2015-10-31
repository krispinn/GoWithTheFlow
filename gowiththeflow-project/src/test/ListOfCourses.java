package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import flowmodel.CourseModel;

/**
 * This class reads in a list of course data and generates an ArrayList with that data.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason Blig
 */
public class ListOfCourses {

	/**
	 * The name of the input file with the course data.
	 */
	private String inputFile;

	/**
	 * A course subject (CS, MAT, etc).
	 */
	private String subject;

	/**
	 * A course number (1063, 3443, etc).
	 */
	private int courseNumber;

	/**
	 * A name of a course (Calculus II, Application Programming, etc).
	 */
	private String courseName;

	/**
	 * A String containing prerequisite courses.
	 */
	private String prerequisiteCourses;

	/**
	 * A String containing concurrent enrollment courses.
	 */
	private String concurrentEnrollment;

	/**
	 * The original line of text containing the prerequisites, concurrent enrollment courses, and
	 * other information.
	 */
	private String courseEnrollmentInfo;

	/**
	 * A description of a course.
	 */
	private String courseDescription;

	private int num;
	
	/**
	 * An ArrayList containing all the previous data.
	 */
	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>();

	/**
	 * The constructor initializes the inputFile field.
	 * 
	 * @param inputFileName
	 *            the name of the input file
	 */
	public ListOfCourses(String inputFileName) {
		inputFile = inputFileName;
	}

	/**
	 * Reads in and parses the data from the file and populates the ArrayList.
	 * 
	 * @return an ArrayList containing the info for all the courses of a single major
	 * @throws Exception
	 */
	public ArrayList<CourseModel> read() throws Exception {

		String line;
		String tokens[] = new String[7];
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		int num = 0;
		
		while (bufferedReader.ready()) {

			line = bufferedReader.readLine();
			tokens = line.split("\\|");
			subject = tokens[0].trim();
			courseNumber = Integer.parseInt(tokens[1].trim());
			courseName = tokens[2].trim();
			prerequisiteCourses = tokens[3].trim();
			concurrentEnrollment = tokens[4].trim();
			courseEnrollmentInfo = tokens[5].trim();
			courseDescription = tokens[6].trim();
			
			//System.out.println(prerequisiteCourses);
//			System.out.println(subject + " " + courseNumber + " " + courseName + " "
//					+ prerequisiteCourses + " " + concurrentEnrollment + " " + courseEnrollmentInfo
//					+ " " + courseDescription);

			
			CourseModel course = new CourseModel(subject, courseNumber, courseName, prerequisiteCourses,
					concurrentEnrollment, courseDescription, courseEnrollmentInfo, num++);
			
			listOfCourses.add(course);
			
		}

		bufferedReader.close();

		return listOfCourses;

	}

}
