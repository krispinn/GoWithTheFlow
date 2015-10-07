package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import GUI.DemoController;

/**
 * This demonstrates the model-view-controller design pattern.
 * Adapted from Figures 12.23 and 12.34.
 * @author Tom Bylander
 */
public class DemoMVC {
	/**
	 * main method starts the application
	 */
	public static void main(String[] args) {
		DemoModel model = new DemoModel();
		DemoView view = new DemoView(model);
		DemoController controller = new DemoController(model, view);
		
		// register controller as the listener to components in the view
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}
