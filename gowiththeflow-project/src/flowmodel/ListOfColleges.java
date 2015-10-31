package flowmodel;

import java.util.ArrayList;
import java.util.Arrays;

public class ListOfColleges {

	private ArrayList<String> list = new ArrayList<String>(Arrays.asList("Architecture", "Business",
			"Education and Human Development", "Engineering", "Liberal and Fine Arts",
			"Public Policy", "Sciences"));
	
	public ListOfColleges() {
		
	}
	
	public ArrayList<String> getDepartments() {
		System.out.println(list);
		return list;
	}
}
