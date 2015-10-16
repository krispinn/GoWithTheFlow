package gowiththeflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Takes a URL and returns the source code for that URL
 * 
 * @author gowiththeflow: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas, Mostafa Dabas
 *
 */
public class DeptSourceCode {

	// Declaring variables
	private URL url;
	private File outputFile;

	/**
	 * Creates the DeptSourceCode object which has two fields url - holds the
	 * actual URL of the site that is being used outputFile - the file being
	 * used to store the taken source code, usually a .txt
	 * 
	 * @param inputUrl
	 *            The URL where the source code is coming from
	 * @param outputFileName
	 *            A name to name the file that the code will be put into for
	 *            later use
	 * @throws Exception
	 */
	public DeptSourceCode(String inputUrl, String outputFileName) throws Exception {
		url = new URL(inputUrl);
		outputFile = new File(outputFileName);
		if (!outputFile.exists())
			outputFile.createNewFile();
		writeToFile();
	}//end constructor

	/**
	 * Writes the source code to the given output file
	 * 
	 * @throws Exception
	 */
	private void writeToFile() throws Exception {

		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
		FileWriter fileWriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String inputLine;
		
		while ((inputLine = bufferedReader.readLine()) != null) {
			bufferedWriter.write(inputLine);
			bufferedWriter.newLine();
		} //end while
		
		bufferedReader.close();
		bufferedWriter.close();
	}//end method writeToFile
	
}//end class DeptSourceCode