package test;
import GUI.*;
import gowiththeflow.CourseList;

import javax.swing.*;
import java.util.ArrayList;

public class TestDriver {

	public static void main(String[] args) throws Exception {
		
		Reader test = new Reader("data/courselists/sciences_computerscience.txt");

		//Reader test = new Reader("data/sciences_computerscience.txt");
		
		ArrayList<String[]> temp = test.read();	
		
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, temp);
		FlowController controller = new FlowController(model, view);
		
		view.registerListener(controller);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);
		
	}
	

}
