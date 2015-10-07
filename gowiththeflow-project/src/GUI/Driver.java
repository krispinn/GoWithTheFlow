package GUI;
import java.awt.*;
import javax.swing.*;

import GUI.FlowController;

/**
 * This demonstrates the model-view-controller design pattern.
 * Adapted from Figures 12.23 and 12.34.
 * @author Tom Bylander
 */
public class Driver {
	/**
	 * main method starts the application
	 */
	public static void main(String[] args) {
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model);
		FlowController controller = new FlowController(model, view);
		
		// register controller as the listener to components in the view
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(500, 600);
		view.setVisible(true);
	}
}
