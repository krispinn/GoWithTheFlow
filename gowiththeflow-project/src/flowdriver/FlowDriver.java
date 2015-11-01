package flowdriver;

import flowguicontroller.FlowController;
import flowguicontroller.InteractiveController;
import flowguimodel.GraphModel;
import flowguimodel.ListModel;
import flowguimodel.MajorModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguiview.FlowView;
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

		//new GenerateInfo();

		MajorModel majorModel = new MajorModel("data/courselists/sciences_mathematics.txt");
		
		GraphModel graphModel = new GraphModel(majorModel.getCourseModelList());
		MxGraphModel mxgModel = new MxGraphModel(graphModel);
		MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
		
		ListModel listModel = new ListModel();
		InteractiveView interactiveView = new InteractiveView(listModel);
		FlowView flowView = new FlowView(interactiveView, graphComponent);
		
		InteractiveController interactiveController = new InteractiveController(interactiveView);
		FlowController flowController = new FlowController(graphModel, listModel, flowView, interactiveView);
		
	}
}		

