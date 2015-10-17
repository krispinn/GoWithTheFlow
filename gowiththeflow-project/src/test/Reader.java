package test;

import java.io.*;

public class Reader {
	
	private String inputFile;
	
	private String subject;
	private int courseNumber;
	private String courseName;
	private String prerequisites;
	private String concurrentEnrollment;
	
	public Reader(String inputFileName) {
		
		inputFile = inputFileName;
		
	}
	
	public void read() throws Exception{
		
		String line;
		String tokens[];
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		
		while(bufferedReader.ready()) {
			line = bufferedReader.readLine();
			System.out.println(line);
			tokens = line.split("|");
			subject = tokens[0];
			courseNumber = 5;
			courseName = tokens[2];
			prerequisites = tokens[3];
			concurrentEnrollment = tokens[4];
			System.out.println(subject + courseNumber + courseName + prerequisites + concurrentEnrollment);
		}
		
		bufferedReader.close();
		
	}
	
	
}