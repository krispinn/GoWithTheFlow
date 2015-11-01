package flowdriver;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.ListModel;
import flowguimodel.MajorModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguiview.FlowView;

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
		InteractiveModel interactiveView = new InteractiveModel();
		FlowView flowView = new FlowView(interactiveView, graphComponent);
		
		FlowController flowController = new FlowController(graphModel, listModel, flowView, interactiveView);
		
	}
}		

