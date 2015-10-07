package gowiththeflow;
import java.net.*;
import java.io.*;

/**
 * Takes a URL and returns the source code for that URL
 * 
 * @author gowiththeflow: 	Bilal Siddiqui, 
 * 							Danny Tsang, 
 * 							Jason Blig, 
 * 							Miguel Cardenas, 
 * 							Mostafa Dabas
 *
 */
public class DeptSourceCode {

	//Declaring variables
	private URL url;
	private File outputFile;
	
	/**
	 * Creates the DeptSourceCode object which has two fields
	 * url - holds the actual URL of the site that is being used
	 * outputFile - the file being used to store the taken source code, usually a .txt
	 * 
	 * @param inputUrl
	 * 			The URL where the source code is coming from
	 * @param outputFileName
	 * 			A name to name the file that the code will be put into for later use
	 * @throws Exception
	 */
	public DeptSourceCode(String inputUrl, String outputFileName) throws Exception{
		url = new URL(inputUrl);
		outputFile = new File(outputFileName);
		
		writeToFile();
	}
	
	/**
	 * @return Returns name of output file.
	 */
	public String getFileName() {
		return outputFile.getName();
	}
	
	/**
	 * @return Returns the output file.
	 */
	public File getFile() {
		return outputFile;
	}
	
	/**
	 * Writes the source code to the given output file
	 * @throws Exception
	 */
	private void writeToFile() throws Exception{
		if (!outputFile.exists()) outputFile.createNewFile();
		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(url.openStream()));
		
		FileWriter fileWriter = new FileWriter(outputFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		String inputLine;
		while ((inputLine = bufferedReader.readLine()) != null) {
			bufferedWriter.write(inputLine);
			bufferedWriter.newLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
	
	}
	
	
	@Override
	public String toString() {
		return "UrlToSourceCode [catalog=" + url + ", file=" + outputFile + "]";
	}
}