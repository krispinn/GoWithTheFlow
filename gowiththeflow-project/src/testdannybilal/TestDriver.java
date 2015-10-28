package testdannybilal;
import java.util.ArrayList;

import javax.swing.JFrame;

import GUI.FlowListController;
import GUI.FlowModel;
import GUI.FlowMouseController;
import GUI.FlowView;

public class TestDriver {

	public static void main(String[] args) throws Exception {
		
		ListOfCourses test = new ListOfCourses("data/courselists/sciences_computerscience.txt");

		//Reader test = new Reader("data/sciences_computerscience.txt");
		
		ArrayList<Course> temp = test.read();	
		System.out.println(temp);
		Graph g = new Graph(temp);
		//System.out.println(temp);
		
		
		/*FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, temp);
		FlowListController listCtrl = new FlowListController(model, view);
		FlowMouseController mouseCtrl = new FlowMouseController(model, view);
		
		view.registerListListener(listCtrl);
		view.registerMouseListener(mouseCtrl);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);*/
		
	}
	

}
