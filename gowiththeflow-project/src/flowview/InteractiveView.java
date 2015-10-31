package flowview;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import flowcontroller.FlowListController;
import flowcontroller.FlowMouseController;
import flowmodel.ListOfMajors;

/**
 * The view is responsible for displaying the information.
 * The view includes the list of colors and a panel for painting
 * with the mouse.  The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class InteractiveView extends JPanel {
	
	/** 
	 * the JPanel where the user can paint
	 */
	private CourseGenerator mousePanel;
	
	private ListOfMajors listOfColleges;
	/**
	 * the panel where the course Info will be displayed after the user
	 * selected a course
	 */
	private JPanel courseInfoPanel;
		
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView() throws NullPointerException {	
		
		
		
		listOfColleges = new ListOfMajors();
		listOfColleges.getCollegeToMajorMap();
		
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		JList<String> jlist = new JList<String>(dlm);
		for (String s : listOfColleges.getColleges().to) {
			
		}
		
		
		
		courseInfoPanel = new JPanel(new GridLayout(7,1));
		add(courseInfoPanel, BorderLayout.EAST);
		courseInfoPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Course Info"),
                        BorderFactory.createEmptyBorder(5,5,5,150)));
        
    
        courseInfoPanel.add(new JLabel("CS 1063 - "));
        courseInfoPanel.add(new JLabel("Introduction to Computer Programming I"));
        courseInfoPanel.add(new JLabel("Prerequisites:"));
        courseInfoPanel.add(new JLabel());
        courseInfoPanel.add(new JLabel("Concurrent Courses:"));
        courseInfoPanel.add(new JLabel());
        
        //courseInfoPanel.add(jlist);

	} // end constructor

	/**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerMouseListener(FlowMouseController mouse) {
		mousePanel.addMouseMotionListener(mouse);
	}
	
	/**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerListListener(FlowListController listener) {
		//colorList.addListSelectionListener(listener);
	}

}
