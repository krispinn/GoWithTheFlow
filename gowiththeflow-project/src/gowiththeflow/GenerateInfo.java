package gowiththeflow;

import java.util.ArrayList;
import java.util.Arrays;

public class GenerateInfo {

	String url = "";
	String catalogFileName = "";
	String departmentFileName = "";
	
	public GenerateInfo(String url, String catalogFileName, String departmentFileName) throws Exception{
		this.url = url;
		this.catalogFileName = catalogFileName;
		this.departmentFileName = departmentFileName;
		generate();
	}
	
	public void generate() throws Exception{
		
		DeptSourceCode catalogDepartments = new DeptSourceCode(url, catalogFileName);

		System.out.println("Step 1");
		
		//DeptMajorList match = new DeptMajorList(catalogFileName, "^.*undergraduate/(.*)/\">", departmentFileName);

		System.out.println("Step 2");
		
	}
}
