package gowiththeflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.net.*;
import java.io.*;

public class CourseList {

	// the department of the major
	private String department;
	private String major;
	// the subject of the courses

	public CourseList(String department, String major) throws Exception {
		this.department = department;
		this.major = major;
		generateCourses();
	}

	public void generateCourses() throws Exception {

		// pattern to match the subject, course number, and course name, respectively
		// opens a web page with a degree's courses as input
		// creates a Pattern object using the above pattern
		// the full URL to be used as the input source
		// creates an output file named after the degree
		String courseDataPattern = "([A-Z]+)&#160;(\\d+)\\.  ([A-Za-z ]+)";
		Pattern coursePattern = Pattern.compile(courseDataPattern);
		File courseFile = new File("data/" + this.department + "_" + this.major + ".txt");
		String address = "http://catalog.utsa.edu/undergraduate/" + this.department + "/"
				+ this.major + "/#courseinventory";
		URL coursePage = new URL(address);

		// if file doesn't exist, create it
		if (!courseFile.exists())
			courseFile.createNewFile();

		// used to write to the output file
		FileWriter fw = new FileWriter(courseFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedReader in = new BufferedReader(new InputStreamReader(coursePage.openStream()));
		// temporary input buffer
		String inputLine;

		// reads in the web page's HTML line by line
		while ((inputLine = in.readLine()) != null) {
			// creates a Matcher object to compare the input line with the pattern
			Matcher courseData = coursePattern.matcher(inputLine);

			// if there was a pattern match, write the data to the output file
			if (courseData.find()) {
				bw.write(courseData.group(1) + " " + courseData.group(2) + " "
						+ courseData.group(3));

				// get the prerequisites
				String tmp = getPrereq(in, bw);
				// get the concurrent enrollment courses
				getConcurrent(in, bw, tmp);
				// move to the next line so that each course will be on its own line
				bw.newLine();
			}
		}
		in.close();
		bw.close();
	}

	public String getPrereq(BufferedReader in, BufferedWriter bw) throws Exception {
		// temporary input buffer
		String inputLine;
		// prereqs and concurrent enrollment courses are always two lines below course data
		inputLine = in.readLine();
		inputLine = in.readLine();
		// create a separator for the prereqs
		bw.write(" | P");

		// check if there are prereqs
		if (inputLine.matches("^Prerequisite.*")) {
			// create an array of strings using a space field separator
			String[] inputFields = inputLine.split(" ");

			// look for the prereqs in the sentence
			for (int i = 1; i < inputFields.length; i++) {
				// if we started reading concurrent enrollment classes, break out of loop
				if (inputFields[i].matches("[Cc]oncurrent"))
					return inputLine;
				// checks to see if a course subject was found
				if (inputFields[i].matches("[A-Z]+")) {
					// remove unnecessary punctuation from the next element (course number)
					inputFields[i + 1] = inputFields[i + 1].replace(",", "");
					inputFields[i + 1] = inputFields[i + 1].replace(".", "");
					// write the course subject and number to the output file
					bw.write(" " + inputFields[i] + " " + inputFields[i + 1]);
					// used to skip past the already read/written course number
					i++;
				}
			}
			return "none";
		}
		return inputLine;
	}

	public void getConcurrent(BufferedReader in, BufferedWriter bw, String inputLine) throws Exception {
		// create a separator for the concurrent enrollment courses
		bw.write(" | C");
		
		// return if there are no concurrent enrollment courses
		if (inputLine.equals("none"))
			return;

		// check if there are concurrent enrollment courses
		if (inputLine.matches(".*[Cc]oncurrent.*")) {
			// create an array of strings using a space field separator
			String[] inputFields = inputLine.split(" ");
			// find where concurrent enrollment courses begin in the sentence
			int conIndex = Arrays.asList(inputFields).indexOf("Concurrent");
			// if the above statement returns -1, then "concurrent" has a lower-case 'c'
			if (conIndex == -1)
				conIndex = Arrays.asList(inputFields).indexOf("concurrent");

			// look for the concurrent enrollment courses in the sentence
			for (int i = conIndex + 1; i < inputFields.length; i++) {
				// checks to see if a course subject was found
				if (inputFields[i].matches("[A-Z]+")) {
					// remove unnecessary punctuation from the next element (course number)
					inputFields[i + 1] = inputFields[i + 1].replace(",", "");
					inputFields[i + 1] = inputFields[i + 1].replace(".", "");
					// write the course subject and number to the output file
					bw.write(" " + inputFields[i] + " " + inputFields[i + 1]);
					// used to skip past the already read/written course number
					i++;
				}
			}
		}
	}
}

/*
 * Sample Output Lines:
 * CS 1143 Web Design | P | C 
 * CS 3423 Systems Programming | P CS 2121 CS 2123 | C CS 3421
 */
