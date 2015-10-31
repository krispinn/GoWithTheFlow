package flowguiview;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Map.Entry;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
	 * the JPanel where the user can paint
	 */
	
	private ListModel listOfColleges = new ListModel();
	/**
	 * the panel where the course Info will be displayed after the user
	 * selected a course
	 */
	private JPanel courseInfoPanel;

	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	
	private JList<String> jlist = new JList<String>(dlm);
	
	FlowController flowController;
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView() throws NullPointerException {	
		
		for (Entry<String, LinkedList<String>> entry : listOfColleges.getCollegeToMajorMap().entrySet()) {
			String key = entry.getKey();
			dlm.addElement(key);
		}
		
		courseInfoPanel = new JPanel(new GridLayout(7,1));
		add(courseInfoPanel, BorderLayout.EAST);
		courseInfoPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Course Info"),
                        BorderFactory.createEmptyBorder(5,5,5,150)));
        
		courseInfoPanel.add(jlist);
		registerListener();
		
	} // end constructor
	
	public void registerListener() {
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if(!event.getValueIsAdjusting()) {
					
					/* NOT WORKING
					JList list = (JList) event.getSource();
					int selected = list.getSelectedIndex();
					System.out.println(selected);
					//flowController.setCollege(selected);
					ListModel lm = new ListModel();
					lm.getColleges(selected);
					*/
				}
			}
		};
		jlist.addListSelectionListener(listSelectionListener);
	}
	
	
}
