package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import gowiththeflow.Course;

public class Reader {
	
	private String inputFile;
	
	private String subject;
	private int courseNumber;
	private String courseName;
	private String prerequisites;
	private String concurrentEnrollment;
	private String line1;
	private String line2;
	private ArrayList<String[]> listOfCourses = new ArrayList<>();
	
	public Reader(String inputFileName) {
		
		inputFile = inputFileName;
		
	}
	
	public ArrayList<String[]> read() throws Exception{
		
		String line;
		String tokens[] = new String[7];
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		while(bufferedReader.ready()) {
			Course course = new Course();
			
			line = bufferedReader.readLine();
			tokens = line.split("\\|");
			subject = tokens[0].trim();
			courseNumber = Integer.parseInt(tokens[1].trim());
			courseName = tokens[2].trim();
			prerequisites = tokens[3].trim();
			concurrentEnrollment = tokens[4].trim();
			line1 = tokens[5].trim();
			line2 = tokens[6].trim();
			
			System.out.println(subject + " " + courseNumber + " " + courseName + " " + prerequisites + " " + concurrentEnrollment
					+ " " + line1 + " " + line2);
			
			listOfCourses.add(tokens);
			
		}
		
		bufferedReader.close();
		
		return listOfCourses;
		
	}
	
}
