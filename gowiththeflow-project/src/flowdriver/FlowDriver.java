package flowdriver;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import flowdata.GenerateInfo;
import flowguicontroller.FlowController;
import flowguimodel.ListModel;
import flowguiview.GraphView;
import flowguiview.InteractiveView;

/**
 * Executes the main method and finds departments/majors from given UTSA URL
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa
 *         Dabas
 * 
 */
public class FlowDriver {
	
/**
 * 
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {

		//ListOfCourses test = new ListOfCourses("data/courselists/engineering_electricalcomputerengineering.txt");
		
		//new GenerateInfo();
		//GraphModel graphModel = new GraphModel(test);
		ListModel listModel = new ListModel();
		InteractiveView interactiveView = new InteractiveView();
		GraphView graphView = new GraphView(interactiveView);
		
		FlowController flowController = new FlowController(null, listModel, graphView, interactiveView);
		
	}
}		

