package flowview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

import flowcontroller.FlowListController;
import flowcontroller.FlowMouseController;
import flowmodel.CourseModel;
import flowmodel.FlowModel;

/**
 * The view is responsible for displaying the information.
 * The view includes the list of colors and a panel for painting
 * with the mouse.  The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class InteractiveView extends JPanel {
    /** 
     * the model of this MVC example 
     */
	private FlowModel model;
	
	/** 
	 * the JPanel where the user can paint
	 */
	private CourseGenerator mousePanel;
	
	/** 
	 * for displaying a list of colors
	 */
	private JList colorList;
	
	/** 
	 * the panel where the JList will be placed 
	 */
	private JPanel listPanel;

	/**
	 * the panel where the course Info will be displayed after the user
	 * selected a course
	 */
	private JPanel courseInfoPanel;
	/** 
	 * the String names of the colors that the user can select 
	 */
	private static final String[] colorNames = {"Chemistry", "Computer Science", "Geological Sciences", "Mathematics", "Black", "Blue", "Cyan",
		"Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
		"Orange", "Pink", "Red", "White", "Yellow"};
	
	/** 
	 * the Colors that the user can select 
	 */
	private static final Color[] colors = {Color.BLACK, Color.ORANGE,
		Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
		Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
		Color.RED, Color.WHITE, Color.YELLOW};
	
	private ArrayList<CourseModel> courseList;
	
	/**
	 * Create and organize the components of the window.
	 */
	public InteractiveView() throws NullPointerException {
		//super("Major Flow Chart");
		//this.model = panel;
		//courseList.toArray(this.courseList);
		//this.courseList = courseList;
		/* CENTER: Add a panel that the user can draw on. */
		//mousePanel = new CourseGenerator(panel);
		//mousePanel.setBackground(Color.WHITE);
		//add(mousePanel, BorderLayout.CENTER);
		
		/*mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		try {
			Object v1 = graph.insertVertex(parent, null, "Hello", 20, 20, 80, 30);
			Object v2 = graph.insertVertex(parent, null, "World", 240, 150, 80, 30);
			graph.insertEdge(parent,  null,  "Edge",  v1,  v2);
		} finally {
			graph.getModel().endUpdate();
		}
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);*/
		
		
		
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

	/**
	 * @return The color selected by the user.
	 */
	public Color getSelectedColor() {
		return colors[colorList.getSelectedIndex()];
	}

}
