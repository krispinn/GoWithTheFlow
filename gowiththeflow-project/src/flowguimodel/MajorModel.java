package flowguimodel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


/**
 * This class reads in a list of course data and generates an ArrayList with that data.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason Blig
 */
public class MajorModel {

	/**
	 * The name of the input file with the course data.
	 */
	private String inputFile;
	
	/**
	 * An ArrayList containing all the previous data.
	 */
	private ArrayList<CourseModel> listOfCourses = new ArrayList<CourseModel>();

	/**
	 * The constructor initializes the inputFile field.
	 * 
	 * @param inputFileName
	 *            the name of the input file
	 * @throws Exception 
	 */
	public MajorModel(String inputFileName) throws Exception {
		this.inputFile = inputFileName;
		this.update();
	}

	/**
	 * Reads in and parses the data from the file and populates the ArrayList.
	 * 
	 * @return an ArrayList containing the info for all the courses of a single major
	 * @throws Exception
	 */
	
	public void update() throws Exception {
		int num = 0;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		while (bufferedReader.ready()) {
			String line = bufferedReader.readLine();
			String tokens[] = line.split("\\|");
			String subject = tokens[0].trim();
			int courseNumber = Integer.parseInt(tokens[1].trim());
			String courseName = tokens[2].trim();
			String prerequisiteCourses = tokens[3].trim();
			String concurrentEnrollment = tokens[4].trim();
			String courseEnrollmentInfo = tokens[5].trim();
			String courseDescription = tokens[6].trim();
			CourseModel course = new CourseModel(subject, courseNumber, courseName, prerequisiteCourses,
					concurrentEnrollment, courseDescription, courseEnrollmentInfo, num++);
			listOfCourses.add(course);
		}
		bufferedReader.close();
	}
	
	public ArrayList<CourseModel> getCourseModelList() throws Exception {

		return listOfCourses;

	}

}
