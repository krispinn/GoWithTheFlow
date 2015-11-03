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

public class UpdateSelectedMajorListener implements MouseListener{

	private ListModel listModel = new ListModel();
	
	private GraphView graphView = null;
	
	private InteractiveView interactiveView;
		
	private FlowView flowView;
	
	private FlowController flowController;
	
	public UpdateSelectedMajorListener(FlowController flowController, GraphModel graphModel, FlowView flowView, InteractiveModel interactiveModel,
			InteractiveView interactiveView, GraphView graphView) {
		this.flowController = flowController;
		this.flowView = flowView;
		this.graphView = graphView;
		this.interactiveView = interactiveView;
		interactiveView.registerUpdateSelectedMajorButton(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		String selected = interactiveView.getSelectedMajor();
		//System.out.println("Updating to: " +selected);
		System.out.println(listModel.getMajorTextFilePath(selected));
		MajorModel majorModel = null;
		GraphModel graphModel = null;
		try {
			majorModel = new MajorModel(listModel.getMajorTextFilePath(selected));
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
