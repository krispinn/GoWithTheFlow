package flowguimodel;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


/**
 * The view is responsible for displaying the information. The view includes the
 * list of colors and a panel for painting with the mouse. The panel is
 * implemented as a separate class so that the painting is relatively
 * flicker-free.
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class InteractiveModel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7304916294755779603L;

	/**
	 * the panel where the course Info will be displayed after the user selected
	 * a course
	 */
	private JPanel information = new JPanel();

	private ListModel listModel = new ListModel();

	private JComboBox<Object> listOfColleges = null;
	
	private JComboBox<Object> listOfMajors = null;
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveModel() {
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
		information.add(new JLabel("College"));
		listOfColleges = new JComboBox<Object>(listModel.getColleges());
		information.add(listOfColleges);
	}

	public void addMajorList() {
		information.add(new JLabel("Major"));
		listOfMajors = new JComboBox<Object>(listModel.getMajorsArray("architecture"));
		information.add(listOfMajors);
	}
	
	public void updateMajorList() {
		
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
