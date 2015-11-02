package flowdriver;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.MajorModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguimodellisteners.VertexListener;
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
		
		GraphModel graphModel = new GraphModel(majorModel);
		MxGraphModel mxgModel = new MxGraphModel(graphModel);
		MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
		InteractiveModel interactiveModel = new InteractiveModel();
		
		InteractiveView interactiveView = new InteractiveView(interactiveModel);
		FlowView graphView = new FlowView(interactiveView, graphComponent);
		
		new FlowController(graphModel, graphView, interactiveModel, interactiveView);
		
		new DownloadListener(graphModel, graphView, interactiveModel,
				interactiveView);
		new CollegeListener(graphModel, graphView, interactiveModel,
				interactiveView);
		new MajorListener(graphModel, graphView, interactiveModel,
				interactiveView);
		new VertexListener(graphModel, graphView, interactiveModel,
				interactiveView);
		
	}
}		

