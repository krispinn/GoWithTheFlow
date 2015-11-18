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
import flowguiview.WelcomeView;

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
		/*Ideally we start the program so that student selects the department and major.*/
		//new WelcomeView();
		MajorModel majorModel = new MajorModel("data/courselists/sciences_computerscience.txt", 1);
		GraphModel graphModel = new GraphModel(majorModel);
		MxGraphModel mxgModel = new MxGraphModel(graphModel);

		MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
		InteractiveModel interactiveModel = new InteractiveModel();
		InteractiveView interactiveView = new InteractiveView(interactiveModel);
		GraphView graphView = new GraphView(graphComponent);
		FlowView flowView = new FlowView(interactiveView, interactiveModel, graphComponent, new WelcomeView());
		
		
		new FlowController(graphModel, flowView, interactiveModel, interactiveView, graphView, graphComponent, mxgModel);
	}
}
