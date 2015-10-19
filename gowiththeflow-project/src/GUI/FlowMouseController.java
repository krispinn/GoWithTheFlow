package GUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.*;
/**
 * Class used to hanle events for hovering mouse over an object (display tooltips etc)
 *
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowMouseController implements MouseMotionListener {
    /** 
     * The model of this MVC
     */
	private FlowModel model;
	
	/** 
	 * The view of this MVC
	 */
	private FlowView view;

	public FlowMouseController(FlowModel model, FlowView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Add a point to the model when the user drags the mouse, and
	 * repaint the window.  Need more logic to draw solid lines.
	 */
	public void mouseDragged(MouseEvent event) {
		Point point = event.getPoint(); // find point
		model.addPoint(point);
		view.repaint();
	} // end method mouseDragged

	/**
	 * This method doesn't do anything, but it needs to be
	 * here to implement MouseMotionListener.
	 */
	public void mouseMoved(MouseEvent event) {
		// this method intentionally left blank
	}

	/*public void actionPerformed(ActionEvent e) {
		
		
	}*/
}
