package flowguimodellisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import flowdata.GenerateInfo;
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

public class RecitationListener implements ActionListener {

	private ListModel listModel = new ListModel();
	
	private GraphView graphView = null;
	
	private InteractiveView interactiveView;
		
	private FlowView flowView;
	
	private FlowController flowController;
	
	public RecitationListener(FlowController flowController, GraphModel graphModel, FlowView flowView, InteractiveModel interactiveModel,
			InteractiveView interactiveView, GraphView graphView) {
		this.flowController = flowController;
		this.flowView = flowView;
		this.graphView = graphView;
		this.interactiveView = interactiveView;
		interactiveView.registerRecitationButton(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		JCheckBox cb = (JCheckBox) e.getSource();
		try {
			if(cb.isSelected() == true) {
				String selected = interactiveView.getSelectedMajor();
				//System.out.println("Updating to: " +selected);
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
				//System.out.println("Updating to: " +selected);
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
