package flowguimodel;

import javax.swing.DefaultListModel;

/**
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class InteractiveModel {

	/**
	 * This variable is used to obtain the majors
	 */
	private ListModel listModel = new ListModel();

	/**
	 * A dynamic list model which refreshes as we go
	 */
	private DefaultListModel<String> majors = new DefaultListModel<String>();

	/**
	 * This is the major which is displayed by default
	 */
	private String selectedMajor;

	/**
	 * This is the course description
	 */
	private String courseInformation;

	/**
	 * An empty constructor
	 */
	public InteractiveModel() {

	}

	/**
	 * 
	 * @param selected
	 */
	public void setMajors(String selected) {
		majors.removeAllElements(); // remove previous list
		System.out.println(selected);
		for (String s : listModel.getMajorsArray(selected)) {
			majors.addElement(s); // populate the majors
		}
	}

	/**
	 * 
	 * @return
	 */
	public String[] getColleges() {
		return listModel.getColleges();
	}

	/**
	 * 
	 * @param selected
	 * 
	 */
	public void setSelectedMajor(String selected) {
		selectedMajor = selected;
	}

	/**
	 * Returns the currently selected major
	 * 
	 * @return a String that contains the currently selected major
	 */
	public String getSelectedMajor() {
		return selectedMajor;
	}

	/**
	 * Returns the major's ListModel
	 * 
	 * @return a DefaultListModel that contains the major's for the given
	 *         college
	 */
	public DefaultListModel<String> getMajorList() {
		return majors;
	}

	/**
	 * Returns the course description
	 * 
	 * @return a String that contains the course's course description
	 */
	public String getCourseInformation() {
		return courseInformation;
	}

	/**
	 * Sets the course description variable
	 * 
	 * @param info
	 *            the course's information
	 */
	public void setCourseInformation(String info) {
		courseInformation = info;
	}
}
