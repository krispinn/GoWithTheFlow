package test;
import GUI.*;
import javax.swing.*;

public class TestDriver {

	public static void main(String[] args) throws Exception {
		
		Reader test = new Reader("data/liberalfinearts_music.txt");

		test.read();
		//Reader test = new Reader("data/sciences_computerscience.txt");
		
		//String[] courseList = test.read();
		//test.read();
		
		String[] courseList = {"course1", "course2", "course3", "course4", "course5"};
		
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model, courseList);
		FlowController controller = new FlowController(model, view);
		
		view.registerListener(controller);
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(800, 500);
		view.setVisible(true);

	}
	

}
