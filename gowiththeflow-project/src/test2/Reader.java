package test2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import testdannybilal.Course;

/**
 * This class reads in a list of course data and generates an ArrayList with that data.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason Blig
 */
public class Reader {

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

	/**
	 * An ArrayList containing all the previous data.
	 */
	private ArrayList<Course> listOfCourses = new ArrayList<>();

	/**
	 * The constructor initializes the inputFile field.
	 * 
	 * @param inputFileName
	 *            the name of the input file
	 */
	public Reader(String inputFileName) {
		inputFile = inputFileName;
	}

	/**
	 * Reads in and parses the data from the file and populates the ArrayList.
	 * 
	 * @return an ArrayList containing the info for all the courses of a single major
	 * @throws Exception
	 */
	public ArrayList<Course> read() throws Exception {

		String line;
		String tokens[] = new String[7];
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));

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

//			System.out.println(subject + " " + courseNumber + " " + courseName + " "
//					+ prerequisiteCourses + " " + concurrentEnrollment + " " + courseEnrollmentInfo
//					+ " " + courseDescription);

			/*
			Course course = new Course(subject, courseNumber, courseName, prerequisiteCourses,
					concurrentEnrollment, courseDescription, courseEnrollmentInfo);
			
			listOfCourses.add(course);
			*/
			
		}

		bufferedReader.close();

		return listOfCourses;

	}

}
