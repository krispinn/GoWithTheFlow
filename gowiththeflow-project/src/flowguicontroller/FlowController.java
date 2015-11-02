package flowguicontroller;

import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguimodellisteners.UpdateSelectedMajorListener;
import flowguimodellisteners.VertexListener;
import flowguiview.FlowView;
import flowguiview.GraphView;
import flowguiview.InteractiveView;

/**
 * Controller used to handle events related GUI
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class FlowController {

	public GraphModel graphModel;
	public FlowView flowView;
	public InteractiveView interactiveView;
	public InteractiveModel interactiveModel;
	public GraphView graphView;
	public MxGraphComponentModel graphComponent;

	public FlowController(GraphModel graphModel, FlowView flowView, InteractiveModel interactiveModel,
			InteractiveView interactiveView, GraphView graphView, MxGraphComponentModel graphComponent) {
		this.graphModel = graphModel;
		this.flowView = flowView;
		this.interactiveModel = interactiveModel;
		this.interactiveView = interactiveView;
		this.graphView = graphView;
		this.graphComponent = graphComponent;
		
		new DownloadListener(interactiveView);
		new CollegeListener(interactiveModel, interactiveView);
		new MajorListener(interactiveModel, interactiveView);
		new VertexListener(graphModel, interactiveModel, interactiveView, graphComponent, graphView);
		new UpdateSelectedMajorListener(graphModel, flowView, interactiveModel, interactiveView, graphView);
	}

}
