package flowguimodel;

import javax.swing.DefaultListModel;

public class InteractiveModel {
	
	
	/**
	 * Below are the variables we use to construct the model 
	 */
	
	private ListModel listModel = new ListModel();            //  we will be using this to get the majors
		
	private DefaultListModel<String> majors = new DefaultListModel<String>();  // dynamic list model which refreshes as we go
	
	private String selectedMajor;   // this is the major which is displayed by default
	
	private String courseInformation;      // the course descriptions
	
	
	/**
	 * empty constructor
	 */
	public InteractiveModel() {  
		
	}
	
	
	/**
	 *  
	 */
	
	public void setMajors(String selected) {
		majors.removeAllElements();               // remove previous list
		System.out.println(selected);               
		for(String s : listModel.getMajorsArray(selected)) {                
			majors.addElement(s);                                   // populate the majors
		}
	}
	
	/**
	 * 
	 */
	
	public String[] getColleges() {
		return listModel.getColleges();
	}

	public void setSelectedMajor(String selected) {
		selectedMajor = selected;
	}
	
	public String getSelectedMajor() {
		return selectedMajor;
	}
	
	public DefaultListModel<String> getMajorList() {
		return majors;
	}
	
	/**
	 * The method returns the course description 
	 */
	
	public String getCourseInformation() {
		return courseInformation;
	}
	
	/**
	 * The method below sets the course description
	 */
	
	public void setCourseInformation(String info) {
		courseInformation = info;
	}
}
