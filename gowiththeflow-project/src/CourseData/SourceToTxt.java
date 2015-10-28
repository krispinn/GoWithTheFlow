package CourseData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DeptMajorList finds a regular expression from source code and
 * outputs what it finds to a text file.
 * 
 * @author CourseData: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas, Mostafa Dabas
 */
public class SourceToTxt {

	// Declaring variables
	private String inputFile;
	private String expression;
	private File outputFile;

	/**
	 * Constructor method MatchPatternFromSourceCode sets fields 'inputFile',
	 * 'expression', and 'outputFile' 'outputFile' is a File object
	 * 
	 * A call is made to match() method.
	 * 
	 * @param inputFileName
	 *            Name of input file
	 * @param inputExpression
	 *            Regular expression to match
	 * @param outputFileName
	 *            Name of output file
	 * @throws Exception
	 *             Throws Exception
	 */
	public SourceToTxt(String inputFileName, String inputExpression, String outputFileName) throws Exception {

		inputFile = inputFileName; // file containing source code
		expression = inputExpression; // expression to search for
		outputFile = new File(outputFileName); // output to this file name
		if (!outputFile.exists())
			outputFile.createNewFile();
		match();
	} //end constructor

	/**
	 * match method creates four objects: BufferedReader - used to read data
	 * from an input file. Pattern - used to match the pattern with the source
	 * code. FileWriter - used to create the file that the matches will be
	 * written to. BufferedWriter - used to efficiently write to output file
	 * 
	 * After the objects are created a line is read from the input file and it
	 * is compared to the pattern(regex) when there is match, the matched string
	 * is then written to the output file.
	 * 
	 * open files are then closed.
	 * 
	 * @throws Exception
	 *             Throws Exception
	 */
	public void match() throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		Pattern compiledRegexPattern = Pattern.compile(expression);
		FileWriter fileWriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		while (bufferedReader.ready()) {
			
			String temporaryString = bufferedReader.readLine();
			
			if (temporaryString.matches("^\\s+.*href=\"/undergraduate/.*$")) {
				Matcher matcher = compiledRegexPattern.matcher(temporaryString);
				
				while (matcher.find()) {
					bufferedWriter.write(matcher.group(1));
					bufferedWriter.newLine();
				} // end while
				
			} // end if
			
		} // end while
		bufferedReader.close();
		bufferedWriter.close();

	}// end method match

}// end class
