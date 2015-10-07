package GUI;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 * This is part of the view allowing the mouse to paint a JPanel.
 * This is modified from Fig 12.34.
 * @author Deitel & Associates, Inc.
 * @author Tom Bylander
 */
public class CourseGenerator extends JPanel {
    /** 
     * The model of this MVC example (it stores the points) 
     */
	private FlowModel model;

	/**
	 * Store the model that holds the points to be drawn.
	 * @param model
	 */
	public CourseGenerator(FlowModel model) {
		this.model = model;
	} // end CourseGenerator constructor

	/**
	 * Draw ovals in a 4-by-4 bounding box at specified locations on
	 * the panel.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g); // clears drawing area
		
		// draw all points
		int i = 0;
		Point point = model.getPoint(0);
		while (point != null) {
			g.setColor(model.getSelectedColor());
			g.fillRect(point.x, point.y, 10, 10);
			i++;
			point = model.getPoint(i);
		}
	} // end method paintComponent
} // end class CourseGenerator
