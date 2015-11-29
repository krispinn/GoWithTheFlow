package flowguimodellisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

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
 * works similar to UpdateSelectedMajorListener.java because it redraws the map
 * when the user clicks the Show/Hide Recitations.
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class RecitationListener implements ActionListener {

	/**
	 * The ListModel that holds all majors and colleges of study.
	 */
	private ListModel listModel = new ListModel();

	/**
	 * The graph's view
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
	 * The main controller for the program
	 */
	private FlowController flowController;

	/**
	 * The constructor for the hide/show recitation button calls the
	 * registerRecitationButton method.
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
	 *            The interactive View's view
	 * @param graphView
	 *            The graph's view
	 */
	public RecitationListener(FlowController flowController, GraphModel graphModel, FlowView flowView,
			InteractiveModel interactiveModel, InteractiveView interactiveView, GraphView graphView) {
		this.flowController = flowController;
		this.flowView = flowView;
		this.graphView = graphView;
		this.interactiveView = interactiveView;
		interactiveView.registerRecitationButton(this);
	}

	/**
	 * when the checkbox is selected the a brand new courselist is created and
	 * redrawn
	 */
	public void actionPerformed(ActionEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();
		try {
			if (cb.isSelected() == true) {
				String selected = interactiveView.getSelectedMajor();
				// System.out.println("Updating to: " +selected);
				System.out.println(listModel.getMajorTextFilePath(selected));
				MajorModel majorModel = null;
				GraphModel graphModel = null;
				try {
					majorModel = new MajorModel(listModel.getMajorTextFilePath(selected), 0);
					graphModel = new GraphModel(majorModel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				MxGraphModel mxgModel = new MxGraphModel(graphModel);
				MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
				graphView = new GraphView(graphComponent);
				flowController.updateVertexListener(graphModel, graphComponent, graphView);
				flowView.setGraph(graphView);
			} else {
				String selected = interactiveView.getSelectedMajor();
				// System.out.println("Updating to: " +selected);
				System.out.println(listModel.getMajorTextFilePath(selected));
				MajorModel majorModel = null;
				GraphModel graphModel = null;
				try {
					majorModel = new MajorModel(listModel.getMajorTextFilePath(selected), 1);
					graphModel = new GraphModel(majorModel);
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				MxGraphModel mxgModel = new MxGraphModel(graphModel);
				MxGraphComponentModel graphComponent = new MxGraphComponentModel(mxgModel);
				graphView = new GraphView(graphComponent);
				flowController.updateVertexListener(graphModel, graphComponent, graphView);
				flowView.setGraph(graphView);
			}
		} catch (Exception e1) {
			System.err.println("Unable to download data!");
			e1.printStackTrace();
		}
	}

}
