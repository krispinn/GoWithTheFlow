package GUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.*;
import test.*;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.*;
import GUI.FlowListController;

/**
 * The view is responsible for displaying the information.
 * The view includes the list of colors and a panel for painting
 * with the mouse.  The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowView extends JFrame {
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
	
	private ArrayList<String[]> courseList;
	
	/**
	 * Create and organize the components of the window.
	 */
	public FlowView(FlowModel model, ArrayList<String[]> courseList) throws NullPointerException {
		super("Major Flow Chart");
		this.model = model;
		//courseList.toArray(this.courseList);
		this.courseList = courseList;
		/* CENTER: Add a panel that the user can draw on. */
		mousePanel = new CourseGenerator(model);
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);
		
		createAGraph();
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
        
        
		/*
		listPanel = new JPanel(new GridLayout(7,1));
		add(listPanel, BorderLayout.EAST);
		listPanel.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Main Menu"),
                        BorderFactory.createEmptyBorder(5,5,5,150)));*/
		/*colorList = new JList(colorNames);
		colorList.setVisibleRowCount(7);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
		/*
		final JComboBox<String> courseBox = new JComboBox<String>(sampleList);
		JPanel smallerPanel = new JPanel(new GridLayout(2,1));
        smallerPanel.setBackground(Color.WHITE);
        smallerPanel.add(new JLabel("Select a Course:"));
        smallerPanel.add(courseBox);
        
        listPanel.add(smallerPanel);
		/*listPanel.setLayout(new GridLayout(6, 2));
		listPanel.add(new JScrollPane(colorList));
		listPanel.add(new JLabel());
		listPanel.add(new JLabel("CS 1063 - Introduction to Computer Programming I"));
		//listPanel.add(new JLabel());
		listPanel.add(new JLabel("Prerequisites:"));
		listPanel.add(new JLabel());
		listPanel.add(new JLabel("Concurrent Courses:"));
		listPanel.add(new JLabel());*/
        /*
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());*/
		
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
		colorList.addListSelectionListener(listener);
	}

	/**
	 * @return The color selected by the user.
	 */
	public Color getSelectedColor() {
		return colors[colorList.getSelectedIndex()];
	}

	/**
	 * Sets the background color of the JList and calls super.paint(g)
	 * to paint the components.
	 */
	public void paint(Graphics g) {
		courseInfoPanel.setBackground(Color.WHITE);
		//listPanel.setBackground(Color.WHITE);
		super.paint(g); // This will paint the components.
	} // end method paint
	
	public void createAGraph () {
		mxGraph graph = new mxGraph();
		
		/*
		 * THIS IS FOR CHANGING THE STYLE OF THE GRAPH OBJECTS
		mxStylesheet stylesheet = graph.getStylesheet();
		Hashtable<String, Object> style = new Hashtable<String, Object>();
		style.put(mxConstants.STYLE_SHAPE, mxConstants.SHAPE_ELLIPSE);
		style.put(mxConstants.STYLE_OPACITY, 100);
		style.put(mxConstants.STYLE_FONTCOLOR, "#000000");
		stylesheet.putCellStyle("ROUNDED", style);*/
		
		Object parent = graph.getDefaultParent();
		graph.getModel().beginUpdate();
		ArrayList<Object> objectList = new ArrayList<>();
		String[] tempList = new String[courseList.size()];
		//tempList = courseList.toArray(tempList);
		System.out.println();
		int j = 0;
		for(String[] s : courseList) {
			tempList[j++] = s[2];
		}
		try {
			
			for (int i = 0; i < courseList.size(); i++) {
				
				objectList.add(graph.insertVertex(parent, null, tempList[i], 
						20+(i*20), 20+(i*20), 80, 30));
				
			}
			
		} finally {
			graph.getModel().endUpdate();
		}
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}
}
