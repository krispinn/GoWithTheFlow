package flowguiview;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
	 * the panel where the course Info will be displayed after the user selected
	 * a course
	 */
	private JPanel information = new JPanel();

	private ListModel listModel = new ListModel();

	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView() {
		addJPanel();
		addCollegeList();
		addMajorList();
		addInfoBox();
	} // end constructor

	public void addJPanel() {
		information.setLayout(new BoxLayout(information, BoxLayout.Y_AXIS));
		//information.setPreferredSize(new Dimension(400, 800));
		add(information, BorderLayout.EAST);
		information.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Information"),
				BorderFactory.createEmptyBorder(5, 5, 5, 150)));
		
	}

	public void addCollegeList() {
		JLabel college = new JLabel("College");
		college.setAlignmentX(LEFT_ALIGNMENT);
		information.add(college);
		JComboBox<Object> listOfColleges = new JComboBox<Object>(listModel.getColleges());
		information.add(listOfColleges);
	}

	public void addMajorList() {
		JLabel major = new JLabel("Major");
		information.add(major);
		JComboBox<Object> listOfMajors = new JComboBox<Object>(listModel.getMajors("architecture"));
		information.add(listOfMajors);
	}
	
	public void addInfoBox() {
		JLabel courseInfo = new JLabel("Course Information");
		information.add(courseInfo);
		JTextArea textArea = new JTextArea();
		
		textArea.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\na "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaa\na\naaaaaaa");
		textArea.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(textArea);
		information.add(scroll);
	}

}
