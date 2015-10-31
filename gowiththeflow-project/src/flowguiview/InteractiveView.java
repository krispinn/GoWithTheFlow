package flowguiview;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import flowguicontroller.FlowController;
import flowguimodel.ListModel;

/**
 * The view is responsible for displaying the information.
 * The view includes the list of colors and a panel for painting
 * with the mouse.  The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class InteractiveView extends JPanel{
	
	/**
	 * the panel where the course Info will be displayed after the user
	 * selected a course
	 */
	private JPanel courseInfoPanel;	
	
	private FlowController flowController;
	
	private JComboBox<Object> listOfMajors = null;
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView() throws NullPointerException {	
				
		courseInfoPanel = new JPanel(new GridLayout(7,1));
		add(courseInfoPanel, BorderLayout.EAST);
		courseInfoPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Course Info"),
                        BorderFactory.createEmptyBorder(5,5,5,150)));
        
		JLabel college = new JLabel("College");
		courseInfoPanel.add(college);
		ListModel listModel = new ListModel();
		JComboBox<Object> listOfColleges = new JComboBox<Object>(listModel.getColleges());
		courseInfoPanel.add(listOfColleges);
		
		JLabel major = new JLabel("Major");
		courseInfoPanel.add(major);
		courseInfoPanel.add(listOfMajors);
		
	} // end constructor	
	
}
