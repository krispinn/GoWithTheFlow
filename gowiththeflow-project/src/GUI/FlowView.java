package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import GUI.FlowController;

/**
 * The view is responsible for displaying the information.
 * The view includes the list of colors and a panel for painting
 * with the mouse.  The panel is implemented as a separate class so that the
 * painting is relatively flicker-free.
 * @author Tom Bylander
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
	 * the String names of the colors that the user can select 
	 */
	private static final String[] colorNames = {"Black", "Blue", "Cyan",
		"Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
		"Orange", "Pink", "Red", "White", "Yellow"};
	
	/** 
	 * the Colors that the user can select 
	 */
	private static final Color[] colors = {Color.BLACK, Color.BLUE,
		Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
		Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
		Color.RED, Color.WHITE, Color.YELLOW};

	/**
	 * Create and organize the components of the window.
	 */
	public FlowView(FlowModel model) {
		super("Major Flow Chart");
		this.model = model;

		/* CENTER: Add a panel that the user can draw on. */
		mousePanel = new CourseGenerator(model);
		mousePanel.setBackground(Color.WHITE);
		add(mousePanel, BorderLayout.CENTER);

		/* EAST: Add a list so the user can select a color. */
		listPanel = new JPanel();
		add(listPanel, BorderLayout.EAST);
		colorList = new JList(colorNames);
		colorList.setVisibleRowCount(7);
		colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPanel.setLayout(new GridLayout(6, 2));
		listPanel.add(new JScrollPane(colorList));
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel());
		listPanel.add(new JLabel("Prerequisites:"));
		listPanel.add(new JLabel());
		listPanel.add(new JLabel("Concurrent Courses:"));
		listPanel.add(new JLabel());
	} // end constructor

	/**
	 * Register the controller as the listener to the JList and the
	 * MousePanel.
	 * @param listener
	 */
	public void registerListener(FlowController listener) {
		colorList.addListSelectionListener(listener);
		mousePanel.addMouseMotionListener(listener);
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
		listPanel.setBackground(model.getSelectedColor());
		super.paint(g); // This will paint the components.
	} // end method paint
}
