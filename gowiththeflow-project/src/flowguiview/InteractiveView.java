package flowguiview;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import flowguimodel.InteractiveModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguimodellisteners.RecitationListener;
import flowguimodellisteners.UpdateSelectedMajorListener;

/**
 * The view is responsible for displaying the information. The view includes the list of colors and
 * a panel for painting with the mouse. The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 */
public class InteractiveView extends JPanel {

	/**
	 * Field for download button which gets course info from website
	 */
	private JButton downloadButton = new JButton("Update Course Information");

	/**
	 * Field for a list of departments/colleges
	 */
	private JList<String> listOfColleges = null;

	/**
	 * Field for a list of majors
	 */
	private JList<String> listOfMajors = null;

	/**
	 * Field for update button which gets info from certain text file (specified by the selected
	 * major)
	 */
	private JButton graphButton = new JButton("Update Selected Major");

	/**
	 * Field for recitation checkbox which toggles the display of labs/recitations
	 */
	private JCheckBox recitationButton = new JCheckBox("Hide Labs/Recitations");

	/**
	 * Field for a text area that will have course info, number, and description
	 */
	private JTextArea jTextArea = new JTextArea();

	/**
	 * Field for scroll pane so that user can read through the text area
	 */
	private JScrollPane scrollPane = new JScrollPane(jTextArea);

	/**
	 * Field for InteractiveModel
	 */
	private InteractiveModel interactiveModel = null;

	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView(InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Information"),
						BorderFactory.createEmptyBorder(0, 0, 0, 0)));

		this.add(downloadButton);

		this.add(new JLabel("College"));
		listOfColleges = new JList<String>(interactiveModel.getColleges());
		this.add(listOfColleges);

		this.add(new JLabel("Major"));
		interactiveModel.setMajors("architecture");
		listOfMajors = new JList<String>(interactiveModel.getMajorList());
		this.add(listOfMajors);

		this.add(graphButton);
		this.add(recitationButton);

		this.add(new JLabel("Course Information"));
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		jTextArea.setEditable(false);
		this.add(scrollPane);
	} // end constructor

	/**
	 * Updates the the text (course info, number, etc) of the text area.
	 * 
	 * @param update
	 */
	public void updateJTextArea(String update) {
		jTextArea.setText(update);
	}

	/**
	 * Registers download button to the view.
	 * 
	 * @param listener
	 */
	public void registerDownloadButton(DownloadListener listener) {
		downloadButton.addMouseListener(listener);
	}

	/**
	 * Registers recitation checkbox to the view.
	 * 
	 * @param listener
	 */
	public void registerRecitationButton(RecitationListener listener) {
		recitationButton.addActionListener(listener);
	}

	/**
	 * Registers download button to the view.
	 * 
	 * @param listener
	 */
	public void registerCollegeListener(CollegeListener listener) {
		listOfColleges.addListSelectionListener(listener);
	}

	/**
	 * Registers major listener button to the view.
	 * 
	 * @param listener
	 */
	public void registerMajorListener(MajorListener listener) {
		listOfMajors.addListSelectionListener(listener);
	}

	/**
	 * Registers update major button to the view.
	 * 
	 * @param listener
	 */
	public void registerUpdateSelectedMajorButton(UpdateSelectedMajorListener listener) {
		graphButton.addMouseListener(listener);
	}

	/**
	 * Retrieves the college(department) that is selected in the list.
	 */
	public String getSelectedCollege() {
		return listOfColleges.getSelectedValue();
	}

	/**
	 * Retrieves the major that is selected in the list.
	 */
	public String getSelectedMajor() {
		return listOfMajors.getSelectedValue();
	}

	/**
	 * Retrieves the list of majors from selected department
	 * 
	 * @param selected
	 */
	public void updateMajors(String selected) {
		listOfMajors.setModel(interactiveModel.getMajorList());
	}

}
