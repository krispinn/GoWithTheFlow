package test2;
import java.util.ArrayList;

import javax.swing.JFrame;

import GUI.FlowListController;
import GUI.FlowModel;
import GUI.FlowMouseController;
import GUI.FlowView;
import testdannybilal.Course;

public class TestDriver {

	public static void main(String[] args) throws Exception {
		
		Reader test = new Reader("data/courselists/sciences_computerscience.txt");

		//Reader test = new Reader("data/sciences_computerscience.txt");
		
		ArrayList<Course> temp = test.read();	
		
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, temp);
		FlowListController listCtrl = new FlowListController(model, view);
		FlowMouseController mouseCtrl = new FlowMouseController(model, view);
		
		view.registerListListener(listCtrl);
		view.registerMouseListener(mouseCtrl);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//need to modify automatically for other display option.
		view.setSize(1366, 768);
		view.setVisible(true);
		
	}
	

}
