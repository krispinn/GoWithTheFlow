package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

/**
 * This demonstrates the controller in a model-view-controller pattern.
 * Adapted from Figures 12.23 and 12.34.
 * @author Tom Bylander
 */
public class FlowController implements ListSelectionListener, MouseMotionListener {
    /** 
     * The model of this MVC example 
     */
	private FlowModel model;
	
	/** 
	 * The view of this MVC example 
	 */
	private FlowView view;

	public FlowController(FlowModel model, FlowView view) {
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

	/**
	 * Update the model when the user selects a color, and repaint the 
	 * window.
	 */
	public void valueChanged(ListSelectionEvent event) {
		Color color = view.getSelectedColor();
		model.setSelectedColor(color);
		view.repaint();
	}
	
	/*public void actionPerformed(ActionEvent e) {
		
		
	}*/
}
