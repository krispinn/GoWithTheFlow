package flowdata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa
 *         Dabas
 */
public class GenerateInfo {

	private String url = "http://catalog.utsa.edu/undergraduate/";
	private String catalogFileName = "data/deptmajorinfo/01_undergraduate_source_code.txt";
	private String departmentFileName = "data/deptmajorinfo/02_list_of_departments.txt";
	private ArrayList<String> departmentsUsedList = new ArrayList<String>();
	private ArrayList<String> departmentsNotUsedList = new ArrayList<String>(
			Arrays.asList("generalinformation", "bachelorsdegreeregulations", "certificateprograms",
					"universitycollege", "honorscollege", "coursedescriptions", "texascommoncoursenumberingsystem",
					"nationalstandardizedtests", "faculty", "azindex"));
	public GenerateInfo() throws Exception {
		step1();
		step2();
		step3();
		step4();
		step5();
		step6();
	}

	/**
	 * Downloads source code from "http://catalog.utsa.edu/undergraduate/" into
	 * a file "01_undergraduate_source_code.txt".
	 * 
	 * @throws Exception
	 */
	private void step1() throws Exception {
		new UrlToSource(url, catalogFileName);
		System.out.println("Step 1");
	}

	/**
	 * Searches for list of departments from "01_undergraduate_source_code.txt"
	 * and outputs it into a file "02_list_of_departments.txt".
	 * 
	 * @throws Exception
	 */
	private void step2() throws Exception {
		new SourceToTxt(catalogFileName, "^.*undergraduate/(.*)/\">", departmentFileName);
		System.out.println("Step 2");
	}

	/**
	 * Downloads source code from "02_list_of_departments.txt" into a
	 * file "03_department_DEPARTMENTNAMEHERE_source_code.txt".
	 * 
	 * @throws Exception
	 */
	private void step3() throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(departmentFileName));
		while (bufferedReader.ready()) {
			String departmentName = bufferedReader.readLine();
			if (departmentsNotUsedList.contains(departmentName)) {
				continue;
			}
			String concatenatedUrl = "http://catalog.utsa.edu/undergraduate/" + departmentName;
			String tempFileName = "data/deptmajorinfo/03_department_" + departmentName + "_source_code.txt";
			new UrlToSource(concatenatedUrl, tempFileName);
			departmentsUsedList.add(departmentName);
		}
		bufferedReader.close();
		System.out.println("Step 3");
	}

	/**
	 * Searches for a list of majors from
	 * "03_department_DEPARTMENTNAMEHERE_source_code.txt" and outputs it into a
	 * file "04_list_of_majors_in_MAJORNAMEHERE.txt".
	 * 
	 * @throws Exception
	 */
	private void step4() throws Exception {
		for (String department : departmentsUsedList) {
			String inputFileName = "data/deptmajorinfo/03_department_" + department + "_source_code.txt";
			String expression = "^.*undergraduate/" + department + "/(.*)/\"";
			String outputFileName = "data/deptmajorinfo/04_list_of_majors_in_" + department + ".txt";
			new SourceToTxt(inputFileName, expression, outputFileName);
		}
		System.out.println("Step 4");
	}

	/**
	 * Concatenates the list of majors from
	 * "04_list_of_majors_MAJORNAMEHERE.txt" into a file
	 * "05_list_of_all_departments_and_majors.txt".
	 * 
	 * @throws Exception
	 */
	private void step5() throws Exception {
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
	}
	
	/**
	 * Generates list of courses from "05_list_of_all_departments_and_majors.txt" into files:
	 * "department_major.txt"
	 * @throws Exception
	 */
	private void step6() throws Exception {
		String inputFileName2 = "data/deptmajorinfo/05_list_of_all_departments_and_majors.txt";
		BufferedReader allListReader = new BufferedReader(new FileReader(inputFileName2));
		String token[];
		while (allListReader.ready()) {
			String departmentAndMajor2 = allListReader.readLine();
			token = departmentAndMajor2.split("\\s");
			new CourseToTxt(token[0], token[1]);
		}
		allListReader.close();
		System.out.println("Step 6");
	}

}
