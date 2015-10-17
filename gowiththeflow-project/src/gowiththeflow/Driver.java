package gowiththeflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Executes the main method and finds departments/majors from given UTSA URL
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa
 *         Dabas
 * 
 */
public class Driver {
	/**
	 * STEP 1: Downloads source code from
	 * "http://catalog.utsa.edu/undergraduate/" into a file
	 * "01_undergraduate_source_code.txt".
	 * 
	 * STEP 2: Searches for list of departments from
	 * "01_undergraduate_source_code.txt" and outputs it into a file
	 * "02_list_of_departments.txt".
	 * 
	 * STEP 3: Downloads source code from "02_list_of_departments.txt" into a
	 * file "03_department_DEPARTMENTNAMEHERE_source_code.txt".
	 * 
	 * STEP 4: Searches for a list of majors from
	 * "03_department_DEPARTMENTNAMEHERE_source_code.txt" and outputs it into a
	 * file "04_list_of_majors_in_MAJORNAMEHERE.txt".
	 * 
	 * STEP 5: Concatenates the list of majors from
	 * "04_list_of_majors_MAJORNAMEHERE.txt" into a file
	 * "05_list_of_all_departments_and_majors.txt".
	 * 
	 * STEP 6: Create course list objects (TESTING IN PROGRESS)
	 * 
	 * @param args
	 *            Does not use command line arguments.
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		// Declaring Variables
		String catalogFileName = "data/deptmajorinfo/01_undergraduate_source_code.txt";
		String departmentFileName = "data/deptmajorinfo/02_list_of_departments.txt";
		ArrayList<String> departmentsNotUsedList = new ArrayList<String>(
				Arrays.asList("generalinformation", "bachelorsdegreeregulations", "certificateprograms",
						"universitycollege", "honorscollege", "coursedescriptions", "texascommoncoursenumberingsystem",
						"nationalstandardizedtests", "faculty", "azindex"));
		ArrayList<String> departmentsUsedList = new ArrayList<String>();

		// STEP 1:
		DeptSourceCode catalogDepartments = new DeptSourceCode("http://catalog.utsa.edu/undergraduate/",
				catalogFileName);

		System.out.println("Step 1");
		
		// STEP 2:
		DeptMajorList match = new DeptMajorList(catalogFileName, "^.*undergraduate/(.*)/\">", departmentFileName);

		System.out.println("Step 2");
		
		// STEP 3:
		BufferedReader bufferedReader = new BufferedReader(new FileReader(departmentFileName));
		while (bufferedReader.ready()) {
			String departmentName = bufferedReader.readLine();
			if (departmentsNotUsedList.contains(departmentName)) {
				continue;
			}
			String concatenatedUrl = "http://catalog.utsa.edu/undergraduate/" + departmentName;
			String tempFileName = "data/deptmajorinfo/03_department_" + departmentName + "_source_code.txt";
			DeptSourceCode departments = new DeptSourceCode(concatenatedUrl, tempFileName);
			departmentsUsedList.add(departmentName);
		}
		bufferedReader.close();

		System.out.println("Step 3");
		
		// STEP 4:
		for (String department : departmentsUsedList) {
			String inputFileName = "data/deptmajorinfo/03_department_" + department + "_source_code.txt";
			String expression = "^.*undergraduate/" + department + "/(.*)/\"";
			String outputFileName = "data/deptmajorinfo/04_list_of_majors_in_" + department + ".txt";
			DeptMajorList major = new DeptMajorList(inputFileName, expression, outputFileName);
		}

		System.out.println("Step 4");
		
		// STEP 5:
		String tempFileName = "data/deptmajorinfo/05_list_of_all_departments_and_majors.txt";
		File finalFile = new File(tempFileName);
		if (finalFile.exists()) {
			finalFile.delete();
		}
		for (String department : departmentsUsedList) {

			String inputFileName = "data/deptmajorinfo/04_list_of_majors_in_" + department + ".txt";
			BufferedReader majorReader = new BufferedReader(new FileReader(inputFileName));
			FileWriter fileWriter = new FileWriter(finalFile.getAbsoluteFile(), true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while (majorReader.ready()) {
				String departmentAndMajor = department + " " + majorReader.readLine();
				bufferedWriter.write(departmentAndMajor);
				bufferedWriter.newLine();
			}
			majorReader.close();
			bufferedWriter.close();
		}
		
		System.out.println("Step 5");
		
		// STEP 6
			String inputFileName2 = "data/deptmajorinfo/05_list_of_all_departments_and_majors.txt";
			BufferedReader allListReader = new BufferedReader(new FileReader(inputFileName2));
			
			String token2[];
			while (allListReader.ready()) {
				String departmentAndMajor2 = allListReader.readLine();
				token2 = departmentAndMajor2.split("\\s");
				CourseList list = new CourseList(token2[0], token2[1]);			}
			allListReader.close();
			
		// STEP 6:
		System.out.println("Step 6");
	}
}		

