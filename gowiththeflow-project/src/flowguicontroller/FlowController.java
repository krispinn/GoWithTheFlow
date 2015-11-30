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
 * Controller used to handle events related GUI, is in charge of creating new listeners.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 */
public class FlowController {

	/**
	 * The Course model
	 */
	public GraphModel graphModel;

	/**
	 * The main view
	 */
	public FlowView flowView;

	/**
	 * The interactive view
	 */
	public InteractiveView interactiveView;

	/**
	 * The interactive view's model
	 */
	public InteractiveModel interactiveModel;

	/**
	 * The graph view
	 */
	public GraphView graphView;

	/**
	 * The graph's component model
	 */
	public MxGraphComponentModel graphComponent;

	/**
	 * The graph's vertex listener (controller)
	 */
	public VertexListener vertexListener;

	/**
	 * The graph's mxGraph model
	 */
	public MxGraphModel mxg;

	/**
	 * The constructor for the controller, calls each Listener using the passed parameters
	 * 
	 * @param graphModel
	 *            The Course model
	 * @param flowView
	 *            The main view
	 * @param interactiveModel
	 *            The Interactive View's model
	 * @param interactiveView
	 *            The Interactive View itself
	 * @param graphView
	 *            The graph's view
	 * @param graphComponent
	 *            The mxGraph component model
	 * @param mxg
	 *            The mxGraph model
	 */
	public FlowController(GraphModel graphModel, FlowView flowView,
			InteractiveModel interactiveModel, InteractiveView interactiveView, GraphView graphView,
			MxGraphComponentModel graphComponent, MxGraphModel mxg) {
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
		new UpdateSelectedMajorListener(this, graphModel, flowView, interactiveModel,
				interactiveView, graphView);
		new RecitationListener(this, graphModel, flowView, interactiveModel, interactiveView,
				graphView);
		new VertexListener(graphModel, interactiveModel, interactiveView, graphComponent, graphView,
				mxg);
	}

	/**
	 * Creates the vertexListener for the FlowController
	 * 
	 * @param graphModel
	 *            The Model
	 * @param graphComponent
	 *            The mxGraph Model
	 * @param graphView
	 *            The graph's view
	 */
	public void updateVertexListener(GraphModel graphModel, MxGraphComponentModel graphComponent,
			GraphView graphView) {
		vertexListener = new VertexListener(graphModel, interactiveModel, interactiveView,
				graphComponent, graphView, mxg);
	}
	
}
