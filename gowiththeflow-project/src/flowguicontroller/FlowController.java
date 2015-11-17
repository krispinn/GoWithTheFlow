package flowguicontroller;

import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguimodellisteners.RecitationListener;
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
	public VertexListener vertexListener;
	public MxGraphModel mxg;

	public FlowController(GraphModel graphModel, FlowView flowView, InteractiveModel interactiveModel,
			InteractiveView interactiveView, GraphView graphView, MxGraphComponentModel graphComponent, MxGraphModel mxg) {
		this.graphModel = graphModel;
		this.flowView = flowView;
		this.interactiveModel = interactiveModel;
		this.interactiveView = interactiveView;
		this.graphView = graphView;
		this.graphComponent = graphComponent;
		this.mxg = mxg;
		
		new DownloadListener(interactiveView);
		new CollegeListener(interactiveModel, interactiveView);
		new MajorListener(interactiveModel, interactiveView);
		new UpdateSelectedMajorListener(this, graphModel, flowView, interactiveModel, interactiveView, graphView);
		new RecitationListener(this, graphModel, flowView, interactiveModel, interactiveView, graphView);
		new VertexListener(graphModel, interactiveModel, interactiveView, graphComponent, graphView, mxg);
	}

	public void updateVertexListener(GraphModel graphModel, MxGraphComponentModel graphComponent, GraphView graphView) {
		vertexListener = new VertexListener(graphModel, interactiveModel, interactiveView, graphComponent, graphView, mxg);
	}
}
