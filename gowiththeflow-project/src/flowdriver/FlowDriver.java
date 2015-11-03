package flowdriver;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.MajorModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguiview.FlowView;
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

		MajorModel majorModel = new MajorModel("data/courselists/sciences_computerscience.txt");
		GraphModel graphModel = new GraphModel(majorModel);
		MxGraphModel mxgModel = new MxGraphModel(graphModel);
				
		MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
		InteractiveModel interactiveModel = new InteractiveModel();
		InteractiveView interactiveView = new InteractiveView(interactiveModel);
		GraphView graphView = new GraphView(graphComponent);
		FlowView flowView = new FlowView(interactiveView, graphComponent);

		new FlowController(graphModel, flowView, interactiveModel, interactiveView, graphView, graphComponent);
	}
}
