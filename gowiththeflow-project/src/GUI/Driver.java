package GUI;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Driver file used to start the GUI portion.
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class Driver {
	/**
	 * main method starts the application
	 */

	public static void main(String[] args) {
		ArrayList<String[]> courseList = new ArrayList<>();
		String[] test1 = {"1", "2"};
		courseList.add(test1);
			//{ "course1", "course2", "course3", "course4", "course5" };
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, courseList);
		//FlowListController controller = new FlowListController(model, view);
		FlowListController listCtrl = new FlowListController(model, view);
		FlowMouseController mouseCtrl = new FlowMouseController(model, view);
		// register controller as the listener to components in the view
		view.registerListListener(listCtrl);
		view.registerMouseListener(mouseCtrl);
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
