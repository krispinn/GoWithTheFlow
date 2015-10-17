package GUI;
import java.awt.*;
import java.util.ArrayList;

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
		ArrayList<String[]> courseList = new ArrayList<>();
		String[] test1 = {"course1", "course2", "course3", "course4", "course5"};
		String[] test2 = {"course6", "course7", "course8", "course9", "course10"};
		String[] test3 = {"course11", "course12", "course13", "course14", "course15"};
		String[] test4 = {"course16", "course17", "course18", "course19", "course20"};
		courseList.add(test1);
		courseList.add(test2);
		courseList.add(test3);
		courseList.add(test4);
		//String[] courseList = {"course1", "course2", "course3", "course4", "course5"};
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, courseList);
		FlowController controller = new FlowController(model, view);
		
		// register controller as the listener to components in the view
		view.registerListener(controller);
		
		// start it up
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);
	}
}
