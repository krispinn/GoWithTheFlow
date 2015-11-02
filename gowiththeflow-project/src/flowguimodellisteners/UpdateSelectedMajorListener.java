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
import flowguiview.InteractiveView;

public class UpdateSelectedMajorListener extends FlowController implements MouseListener{

	private ListModel listModel = new ListModel();
	
	public UpdateSelectedMajorListener(GraphModel graphModel, FlowView graphView, InteractiveModel interactiveModel,
			InteractiveView interactiveView) {
		super(graphModel, graphView, interactiveModel, interactiveView);
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
		MxGraphComponentModel graphComponent = null;
		try {
			MajorModel majorModel = new MajorModel(listModel.getMajorTextFilePath(selected));
			GraphModel graphModel = new GraphModel(majorModel);
			MxGraphModel mxgModel = new MxGraphModel(graphModel);
			graphComponent = new MxGraphComponentModel(mxgModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		graphView.setGraphComponent(graphComponent);
	}

}
