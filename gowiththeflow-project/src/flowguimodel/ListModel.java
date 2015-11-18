package flowguimodel;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class is in charge of populating two maps and an ArrayList that link the
 * colleges and majors, majors and text file names, and college names allows the
 * ability to get these variables as well.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class ListModel {

	/**
	 * a Map that connects the majors to their text files
	 */
	private Map<String, String> majorToTextFileMap = new LinkedHashMap<String, String>();

	/**
	 * a Map that links the colleges to their respective majors
	 */
	private Map<String, LinkedList<String>> collegeToMajorMap = new LinkedHashMap<String, LinkedList<String>>();

	/**
	 * an ArrayList that contains the names of the various colleges of study
	 */
	private ArrayList<String> colleges = new ArrayList<String>();

	/**
	 * Calls ListModel's update method to populate the Model's variables
	 */
	public ListModel() {
		update();
	}

	/**
	 * Populates the MajorToTextFileMap and the CollegeToMajorMap Maps
	 */
	public void update() {
		File folder = new File("data/courselists");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String temp = listOfFiles[i].getName();
				String temp2[] = temp.split("_");

				StringBuilder sb = new StringBuilder();

				for (int j = 1; j < temp2.length; j++) {
					sb.append(temp2[j]);
				}

				String newStr = sb.toString();
				String newStr2 = newStr.replace(".txt", "");

				majorToTextFileMap.put(newStr2, listOfFiles[i].getName());

				if (!collegeToMajorMap.containsKey(temp2[0])) {
					LinkedList<String> majors = new LinkedList<String>();
					collegeToMajorMap.put(temp2[0], majors);
				}
				collegeToMajorMap.get(temp2[0]).add(newStr2);

			}
		}

		for (Map.Entry<String, String> entry : majorToTextFileMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + "\t" + value);
		}

		for (Entry<String, LinkedList<String>> entry : collegeToMajorMap.entrySet()) {
			String key = entry.getKey();
			LinkedList<String> value = entry.getValue();
			System.out.println(key + "\t" + value);
		}
	}

	/**
	 * Returns the model's CollegeToMajorMap
	 * 
	 * @return a Map that contains colleges to majors
	 */
	public Map<String, LinkedList<String>> getCollegeToMajorMap() {
		return collegeToMajorMap;
	}

	/**
	 * Returns the model's MajorToTextFileMap
	 * 
	 * @return a Map that contains Majors to text files
	 */
	public Map<String, String> getMajorToTextFileMap() {
		return majorToTextFileMap;
	}

	/**
	 * Returns the major's file path.
	 * 
	 * @param selected
	 *            currently selected major
	 * @return a String that is a file path
	 */
	public String getMajorTextFilePath(String selected) {
		return "data/courselists/" + majorToTextFileMap.get(selected);
	}

	/**
	 * Returns a list of the available colleges of study.
	 * 
	 * @return a String[] of colleges of study
	 */
	public String[] getColleges() {
		for (Entry<String, LinkedList<String>> entry : collegeToMajorMap.entrySet()) {
			String key = entry.getKey();
			colleges.add(key);
		}
		String[] list = new String[colleges.size()];
		Collections.reverse(colleges);
		list = colleges.toArray(list);

		return list;
	}

	/**
	 * Takes in a college name and returns a list of that college's majors
	 * 
	 * @param college
	 *            the College of Majors
	 * @return a String[] of majors in that college
	 */
	public String[] getMajorsArray(String college) {

		// sets the major's array to equal to the array pointed to by the index
		LinkedList<String> majors = collegeToMajorMap.get(college);

		// we use this to create a temporary holder
		String[] list = new String[majors.size()];

		// convert the major's LinkedList to a string array
		list = majors.toArray(list);

		return list;
	}
}
