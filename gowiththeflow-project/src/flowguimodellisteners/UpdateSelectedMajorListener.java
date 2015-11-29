package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.ListModel;
import flowguimodel.MajorModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguiview.FlowView;
import flowguiview.GraphView;
import flowguiview.InteractiveView;

/**
 * This class is for 'Update Selected Major' button, has a constructor for the
 * listener and performs an action on mouse release.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class UpdateSelectedMajorListener implements MouseListener {

	/**
	 * A ListModel that contains HashMaps for the majors and colleges of study
	 */
	private ListModel listModel = new ListModel();

	/**
	 * The updated view for the graph. On creation, this variable is set to
	 * null.
	 */
	private GraphView graphView = null;

	/**
	 * The interactive view's view
	 */
	private InteractiveView interactiveView;

	/**
	 * The main view
	 */
	private FlowView flowView;

	/**
	 * The main controller
	 */
	private FlowController flowController;

	/**
	 * The constructor for this listener, calls the
	 * registerUpdateSelectedMajorButton method.
	 * 
	 * @param flowController
	 *            The main controller
	 * @param graphModel
	 *            The graph's model
	 * @param flowView
	 *            The main view
	 * @param interactiveModel
	 *            The interactive view's model
	 * @param interactiveView
	 *            The interactive view's view
	 * @param graphView
	 *            The graph's view
	 */
	public UpdateSelectedMajorListener(FlowController flowController, GraphModel graphModel, FlowView flowView,
			InteractiveModel interactiveModel, InteractiveView interactiveView, GraphView graphView) {
		this.flowController = flowController;
		this.flowView = flowView;
		this.graphView = graphView;
		this.interactiveView = interactiveView;
		interactiveView.registerUpdateSelectedMajorButton(this);
	}

	/**
	 * Doesn't do anything on mouse release
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Doesn't do anything if the mouse enters the window
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Doesn't do anything if the mouse exits the window
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Doesn't do anything on mouse press
	 */
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * On mouse release over the 'update selected major' button this method
	 * calls all the necessary methods to update to the currently selected major
	 * in the interactive list.
	 */
	public void mouseReleased(MouseEvent arg0) {
		String selected = interactiveView.getSelectedMajor();
		// System.out.println("Updating to: " +selected);
		System.out.println(listModel.getMajorTextFilePath(selected));
		MajorModel majorModel = null;
		GraphModel graphModel = null;
		try {
			majorModel = new MajorModel(listModel.getMajorTextFilePath(selected), 1);
			graphModel = new GraphModel(majorModel);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MxGraphModel mxgModel = new MxGraphModel(graphModel);
		MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
		graphView = new GraphView(graphComponent);
		flowController.updateVertexListener(graphModel, graphComponent, graphView);
		flowView.setGraph(graphView);
	}

}
