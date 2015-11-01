package flowdriver;

import java.util.ArrayList;

import flowguicontroller.FlowController;
import flowguimodel.CourseModel;
import flowguimodel.GraphModel;
import flowguimodel.ListModel;
import flowguimodel.MxGraphModel;
import flowguiview.GraphView;
import flowguiview.InteractiveView;
import flowtest.ListOfCourses;

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
		ListOfCourses test = new ListOfCourses("data/courselists/sciences_mathematics.txt");
		ArrayList<CourseModel> temp = test.read();
		
		GraphModel graphModel = new GraphModel(temp);
		MxGraphModel mxgModel = new MxGraphModel(graphModel);
		
		ListModel listModel = new ListModel();
		InteractiveView interactiveView = new InteractiveView();
		GraphView graphView = new GraphView(interactiveView, mxgModel);
		
		FlowController flowController = new FlowController(graphModel, listModel, graphView, interactiveView);
		
		graphView.register(flowController);
	}
}		

