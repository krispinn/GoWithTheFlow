package flowguicontroller;

import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

/**
 * Controller used to handle events related GUI
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public abstract class FlowController {

	public GraphModel graphModel;
	public FlowView graphView;
	public InteractiveView interactiveView;
	public InteractiveModel interactiveModel;

	public FlowController(GraphModel graphModel, FlowView graphView,
			InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.graphModel = graphModel;
		this.graphView = graphView;
		this.interactiveModel = interactiveModel;
		this.interactiveView = interactiveView;

	}

}
