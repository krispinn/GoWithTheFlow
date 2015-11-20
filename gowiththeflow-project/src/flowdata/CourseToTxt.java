package flowdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * CourseToTxt generates a list of all courses of a specific subject.
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class CourseToTxt {

	/**
	 * The department of the major.
	 */
	private String department;

	/**
	 * The subject of the courses to be generated.
	 */
	private String major;

	/**
	 * The constructor initializes the fields and calls a function to generate
	 * the course list.
	 * 
	 * @param department
	 *            the department of the major
	 * @param major
	 *            the subject of the courses to be generated
	 * @throws Exception
	 */
	public CourseToTxt(String department, String major) throws Exception {
		this.department = department;
		this.major = major;
		generateCourses();
	}

	/**
	 * Creates a url to a major's courses page with the two fields and generates
	 * a list of courses by parsing the page's HTML data with pattern matching.
	 * 
	 * @throws Exception
	 */
	public void generateCourses() throws Exception {

		// pattern to match the subject, course number, and course name,
		// respectively
		// opens a web page with a degree's courses as input
		// creates a Pattern object using the above pattern
		// the full URL to be used as the input source
		// creates an output file named after the degree
		String courseDataPattern = "([A-Z]+)&#160;(\\d+)\\.  ([A-Za-z-, ']+)";
		Pattern coursePattern = Pattern.compile(courseDataPattern);
		File courseFile = new File("data/courselists/" + this.department + "_" + this.major + ".txt");
		String address = "http://catalog.utsa.edu/undergraduate/" + this.department + "/" + this.major
				+ "/#courseinventory";
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
			// creates a Matcher object to compare the input line with the
			// pattern
			Matcher courseData = coursePattern.matcher(inputLine);

			// if there was a pattern match, write the data to the output file
			if (courseData.find()) {
				if (!courseData.group(2).substring(3, 4).equals("1")) {
					bw.write(courseData.group(1) + " | " + courseData.group(2) + " | " + courseData.group(3));

					// get the prerequisites
					String tmp = getPrereq(in, bw);
					// get the concurrent enrollment courses
					getConcurrent(in, bw, tmp);
					// read in the next line
					inputLine = in.readLine();
					// write enrollment info and course description
					if (inputLine.matches("</p>")) {
						String tmp2 = tmp.replaceAll("<br />", "");
						if (tmp.matches("^Prerequisite.*") || tmp.matches(".*[Cc]oncurrent.*"))
							bw.write(" | " + tmp2 + " | ");
						else
							bw.write(" | | " + tmp2);
					} else {
						String il2 = inputLine.replaceAll("<br />", "");
						bw.write(" | " + tmp + " | " + il2);
					}
					// move to the next line so that each course will be on its
					// own line
					bw.newLine();
				}
			} // end if statement inside while loop
		} // end while loop
		in.close();
		bw.close();
	} // end generateCourses

	/**
	 * This method checks for prerequisites and writes them to the output file
	 * if any are found.
	 * 
	 * @param in
	 *            the input stream from the web page
	 * @param bw
	 *            the output stream to the course list text file
	 * @return a String if there may be concurrent enrollment courses; otherwise
	 *         returns "none"
	 * @throws Exception
	 */
	public String getPrereq(BufferedReader in, BufferedWriter bw) throws Exception {
		// temporary input buffer
		String inputLine;
		// prereqs and concurrent enrollment courses are always two lines below
		// course data
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
				// if we started reading concurrent enrollment classes, break
				// out of loop
				if (inputFields[i].matches("[Cc]oncurrent"))
					return inputLine;
				// checks to see if a course subject was found
				if (inputFields[i].matches("[A-Z][A-Z]+")) {
					// remove unnecessary punctuation from the next element
					// (course number)
					inputFields[i + 1] = inputFields[i + 1].replace(",", "");
					inputFields[i + 1] = inputFields[i + 1].replace(".", "");
					inputFields[i + 1] = inputFields[i + 1].replace(";", "");
					// if next field is not a number, then it is not a course,
					// so skip it
					if (!(inputFields[i + 1].matches("[0-9]{4}")))
						continue;
					// write the course subject and number to the output file
					bw.write(" " + inputFields[i] + " " + inputFields[i + 1]);
					// used to skip past the already read/written course number
					i++;
				} // end if statement inside for loop
			} // end for loop
		} // end large if statement
		return inputLine;
	} // end getPrereq

	/**
	 * This method checks for concurrent enrollment courses and writes them to
	 * the output file if any are found.
	 * 
	 * @param in
	 *            the input stream from the web page
	 * @param bw
	 *            the output stream to the course list text file
	 * @param inputLine
	 *            the line that may contain concurrent enrollment courses
	 * @throws Exception
	 */
	public void getConcurrent(BufferedReader in, BufferedWriter bw, String inputLine) throws Exception {
		// create a separator for the concurrent enrollment courses
		bw.write(" | C");

		// check if there are concurrent enrollment courses
		if (inputLine.matches(".*[Cc]oncurrent.*")) {
			// create an array of strings using a space field separator
			String[] inputFields = inputLine.split(" ");
			// find where concurrent enrollment courses begin in the sentence
			int conIndex = Arrays.asList(inputFields).indexOf("Concurrent");
			// if the above statement returns -1, then "concurrent" has a
			// lower-case 'c'
			if (conIndex == -1)
				conIndex = Arrays.asList(inputFields).indexOf("concurrent");

			// look for the concurrent enrollment courses in the sentence
			for (int i = conIndex + 1; i < inputFields.length; i++) {
				// checks to see if a course subject was found
				if (inputFields[i].matches("[A-Z][A-Z]+")) {
					// remove unnecessary punctuation from the next element
					// (course number)
					inputFields[i + 1] = inputFields[i + 1].replace(",", "");
					inputFields[i + 1] = inputFields[i + 1].replace(".", "");
					inputFields[i + 1] = inputFields[i + 1].replace(";", "");
					// if next field is not a number, then it is not a course,
					// so skip it
					if (!(inputFields[i + 1].matches("[0-9]{4}")))
						continue;
					// write the course subject and number to the output file
					bw.write(" " + inputFields[i] + " " + inputFields[i + 1]);
					// used to skip past the already read/written course number
					i++;
				} // end if statement inside for loop
			} // end for loop
		} // end large if statement
	} // end getConcurrent
} // end class
