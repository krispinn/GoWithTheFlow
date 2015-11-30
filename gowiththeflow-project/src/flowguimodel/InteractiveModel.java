package flowguimodel;

import javax.swing.DefaultListModel;

/**
 * This class contains the information that is used by the interactive view of the display. Holds a
 * list of the Colleges of Study, a List of each of the college's majors, and a selected course's
 * information/description.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 *
 */
public class InteractiveModel {

	/**
	 * This variable contains two maps and an ArrayList used to get linking information for the
	 * majors
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
	 * Sets up the majors ListModel and populates it with various majors
	 * 
	 * @param selected
	 *            the currently selected major
	 */
	public void setMajors(String selected) {
		// remove previous list
		majors.removeAllElements();
		System.out.println(selected);

		// population the majors
		for (String s : listModel.getMajorsArray(selected))
			majors.addElement(s);
	}

	/**
	 * Returns the list of colleges of study
	 * 
	 * @return a String[] that contains the colleges of study
	 */
	public String[] getColleges() {
		return listModel.getColleges();
	}

	/**
	 * Changes the currently selected major to a new value
	 * 
	 * @param selected
	 *            new selected major
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
	 * @return a DefaultListModel that contains the major's for the given college
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
