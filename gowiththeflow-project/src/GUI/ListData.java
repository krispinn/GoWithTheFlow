package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Model for the data in the department and major lists.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class ListData {

	/**
	 * Stores the filename.
	 */
	private String inFile;

	/**
	 * Stores each major with its department.
	 */
	private ArrayList<String[]> majors = new ArrayList<>();

	/**
	 * Constructor that initializes the inFile field and invokes getMajors.
	 * 
	 * @param file
	 *            the filename of the list of majors
	 * @throws Exception
	 */
	public ListData(String file) throws Exception {
		this.inFile = file;
		getMajors();
	}

	/**
	 * Reads the file and stores the list majors and their departments in the ArrayList field.
	 * 
	 * @throws Exception
	 */
	public void getMajors() throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(this.inFile));

		while (bufferedReader.ready()) {
			String[] line = bufferedReader.readLine().split(" ");
			majors.add(line);
		}
	}
}
