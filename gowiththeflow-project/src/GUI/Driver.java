package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import GUI.FlowController;
import test.Reader;

/**
 * This demonstrates the model-view-controller design pattern. Adapted from
 * Figures 12.23 and 12.34.
 * 
 * @author Tom Bylander
 */
public class Driver {
	/**
	 * main method starts the application
	 */

	public static void main(String[] args) {
		String[] courseList = { "course1", "course2", "course3", "course4", "course5" };
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, courseList);
		FlowController controller = new FlowController(model, view);

		// register controller as the listener to components in the view
		view.registerListener(controller);

		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);

		// reads in all the departments

		try {
			ListData sample = new ListData("data/deptmajorinfo/05_list_of_all_departments_and_majors.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
