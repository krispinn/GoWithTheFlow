package flowguimodel;

import javax.swing.DefaultListModel;

public class InteractiveModel {
	
	private ListModel listModel = new ListModel();
		
	private DefaultListModel<String> majors = new DefaultListModel<String>();
	
	private String selectedMajor = "architecture";
	
	public InteractiveModel() {
		
	}
	
	public void setMajors(String selected) {
		majors.removeAllElements();
		System.out.println(selected);
		for(String s : listModel.getMajorsArray(selected)) {
			majors.addElement(s);
		}
	}
	
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
}
