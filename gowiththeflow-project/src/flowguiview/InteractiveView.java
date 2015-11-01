package flowguiview;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	 * 
	 */
	private static final long serialVersionUID = 7304916294755779603L;

	/**
	 * the panel where the course Info will be displayed after the user selected
	 * a course
	 */

	private JComboBox<Object> listOfColleges = null;
	
	private JComboBox<Object> listOfMajors = null;
	
	private JButton downloadButton = new JButton("Download Course Information");
	
	private JTextArea jTextArea = new JTextArea();
	
	private JScrollPane scrollPane = new JScrollPane(jTextArea);
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView(ListModel listModel) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Information"),
				BorderFactory.createEmptyBorder(5, 5, 5, 150)));
		//this.setPreferredSize(new Dimension(400, 800));
		
		this.add(downloadButton);
		
		this.add(new JLabel("College"));
		listOfColleges = new JComboBox<Object>(listModel.getColleges());
		this.add(listOfColleges);
		
		this.add(new JLabel("Major"));
		listOfMajors = new JComboBox<Object>(listModel.getMajorsArray("architecture"));
		this.add(listOfMajors);

		this.add(new JLabel("Course Information"));
		jTextArea.setWrapStyleWord(true);
		this.add(scrollPane);
		jTextArea.append("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\n "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\na "
				+ "aaaaaaaaaaaaaaaaaaaaaaaaa\na\naaaaaaa");
	} // end constructor


}
