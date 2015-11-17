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
	 * An int that holds 0 or 1, 0 means hide recitations 1 means show them.
	 */
	private int recitationCheck;

	/**
	 * The constructor initializes the inputFile field.
	 * 
	 * @param inputFileName
	 *            the name of the input file
	 * @throws Exception 
	 */
	public MajorModel(String inputFileName, int check) throws Exception {
		this.inputFile = inputFileName;
		this.recitationCheck = check;
		this.update();
	}

	/**
	 * Reads in and parses the data from the file and populates the ArrayList.
	 * Depending on if the recitation check box is clicked the flow is built.
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
			//this is where the checkbox affects the flowchart
			if(this.recitationCheck == 0) {
				if(!(courseName.endsWith("Recitation"))){
					CourseModel course = new CourseModel(subject, courseNumber, courseName, prerequisiteCourses,
							concurrentEnrollment, courseDescription, courseEnrollmentInfo, num++);
					listOfCourses.add(course);
				}
			} else {
				CourseModel course = new CourseModel(subject, courseNumber, courseName, prerequisiteCourses,
						concurrentEnrollment, courseDescription, courseEnrollmentInfo, num++);
				listOfCourses.add(course);
			}
		}
		bufferedReader.close();
	}
	
	public ArrayList<CourseModel> getCourseModelList() throws Exception {

		return listOfCourses;

	}

}
