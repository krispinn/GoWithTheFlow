package flowguiview;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import flowguicontroller.InteractiveController;
import flowguimodel.InteractiveModel;
import flowguimodel.ListModel;


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
	private ListModel listModel = new ListModel();
	private JButton downloadButton = new JButton("Download Course Information");
	private JTextArea jTextArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(jTextArea);
	private InteractiveModel interactiveModel = null;
	
	private JList<String> listOfColleges = null;
	
	private JList<String> listOfMajors = null;
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView(InteractiveModel interactiveModel) {
		this.interactiveModel = interactiveModel;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Information"),
				BorderFactory.createEmptyBorder(5, 5, 5, 150)));
		//this.setPreferredSize(new Dimension(400, 800));
		
		this.add(downloadButton);
		
		this.add(new JLabel("College"));
		listOfColleges = new JList<String>(listModel.getColleges());
		this.add(listOfColleges);
		
		this.add(new JLabel("Major"));
		interactiveModel.setMajors("architecture");
		this.updateMajors();
		
		//this.add(listOfMajors);

		this.add(new JLabel("Course Information"));
		jTextArea.setWrapStyleWord(true);
		this.add(scrollPane);
		jTextArea.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\na "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaa\na\naaaaaaa");
				
	} // end constructor

	public String getSelectedCollege() {
		System.out.println(listOfColleges.getSelectedIndex());
		return listOfColleges.getSelectedValue();
	}
		
	public void registerCollegeListener(InteractiveController listener) {
		listOfColleges.addListSelectionListener(listener);
	}
	
	public void updateMajors() {
		//listOfMajors.removeAll();
		//listOfMajors = new JList<String>(interactiveModel.getMajors());
	}

}
