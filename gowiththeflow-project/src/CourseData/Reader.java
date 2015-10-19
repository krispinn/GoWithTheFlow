package CourseData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {
	
	private String inputFile;
	
	private String subject;
	private int courseNumber;
	private String courseName;
	private String prerequisiteCourses;
	private String concurrentEnrollment;
	private String courseEnrollmentInfo;
	private String courseDescription;
	private ArrayList<String[]> listOfCourses = new ArrayList<>();
	
	public Reader(String inputFileName) {
		
		inputFile = inputFileName;
		
	}
	
	public ArrayList<String[]> read() throws Exception{
		
		String line;
		String tokens[] = new String[7];
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		while(bufferedReader.ready()) {
			//Course course = new Course();
			
			line = bufferedReader.readLine();
			tokens = line.split("\\|");
			subject = tokens[0].trim();
			courseNumber = Integer.parseInt(tokens[1].trim());
			courseName = tokens[2].trim();
			prerequisiteCourses = tokens[3].trim();
			concurrentEnrollment = tokens[4].trim();
			courseEnrollmentInfo = tokens[5].trim();
			courseDescription = tokens[6].trim();
			
			System.out.println(subject + " " + courseNumber + " " + courseName + " " + prerequisiteCourses + " " + concurrentEnrollment
					+ " " + courseEnrollmentInfo + " " + courseDescription);
			
			listOfCourses.add(tokens);
			
		}
		
		bufferedReader.close();
		
		return listOfCourses;
		
	}
	
}
