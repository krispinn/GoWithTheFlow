package flowmodel;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class ListOfMajors {
	
	Map<String, String> majorToTextFileMap = new LinkedHashMap<String, String>();
	Map<String, LinkedList<String>> collegeToMajorMap = new LinkedHashMap<String, LinkedList<String>>();
	ArrayList<String> colleges;
	
	public ListOfMajors() {
		populate();
	}
	
	public void populate() {
		File folder = new File("data/courselists");
		File[] listOfFiles = folder.listFiles();
		
		for(int i = 0; i < listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				String temp = listOfFiles[i].getName();
				String temp2[] = temp.split("_");

				StringBuilder sb = new StringBuilder();
				
				for (int j = 1; j < temp2.length; j++) {
					sb.append(temp2[j]);
				}
				
				String newStr = sb.toString();
				String newStr2 = newStr.replace(".txt", "");
				
				majorToTextFileMap.put(newStr2, listOfFiles[i].getName());
				
				if(!collegeToMajorMap.containsKey(temp2[0])) {
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
	
	public Map<String, LinkedList<String>> getCollegeToMajorMap() {
		return collegeToMajorMap;
	}
	
	public Map<String, String> getMajorToTextFileMap() {
		return majorToTextFileMap;
	}
	
	public ArrayList<String> getColleges() {
		for (Entry<String, LinkedList<String>> entry : collegeToMajorMap.entrySet()) {
			String key = entry.getKey();
			colleges.add(key);
		}
		return colleges;
	}
}
