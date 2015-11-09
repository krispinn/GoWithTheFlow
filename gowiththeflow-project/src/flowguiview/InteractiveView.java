package flowguiview;

import javax.swing.*;

import flowguimodel.InteractiveModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguimodellisteners.RecitationListener;
import flowguimodellisteners.UpdateSelectedMajorListener;


/**
 * The view is responsible for displaying the information. The view includes the
 * list of colors and a panel for painting with the mouse. The panel is
 * implemented as a separate class so that the painting is relatively
 * flicker-free.
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class InteractiveView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304916294755779603L;

	/**
	 * the panel where the course Info will be displayed after the user selected
	 * a course
	 */
	
	private JButton downloadButton = new JButton("Update Course Information");
	private JList<String> listOfColleges = null;
	private JList<String> listOfMajors = null;
	private JButton graphButton = new JButton("Update Selected Major");
	private JCheckBox recitationButton = new JCheckBox("Hide Recitations");
	
	private JTextArea jTextArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(jTextArea);
	private InteractiveModel interactiveModel = null;
	
	
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView(InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Information"),
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

	public void updateJTextArea(String update) {
		jTextArea.setText(update);
	}
	
	public void registerDownloadButton(DownloadListener listener) {
		downloadButton.addMouseListener(listener);
	}
	
	public void registerRecitationButton(RecitationListener listener) {
		recitationButton.addActionListener(listener);
	}
	
	public void registerCollegeListener(CollegeListener listener) {
		listOfColleges.addListSelectionListener(listener);
	}
	
	public void registerMajorListener(MajorListener listener) {	
		listOfMajors.addListSelectionListener(listener);
	}
	
	public void registerUpdateSelectedMajorButton(UpdateSelectedMajorListener listener) {
		graphButton.addMouseListener(listener);
	}
	
	public String getSelectedCollege() {
		return listOfColleges.getSelectedValue();
	}
	
	public String getSelectedMajor() {
		return listOfMajors.getSelectedValue();
	}	
	
	public void updateMajors(String selected) {
		listOfMajors.setModel(interactiveModel.getMajorList());
	}

}
