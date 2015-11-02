package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

public class CollegeListener extends FlowController implements ListSelectionListener {
	


	public CollegeListener(GraphModel graphModel, FlowView graphView,
			InteractiveModel interactiveModel, InteractiveView interactiveView) {
		super(graphModel, graphView, interactiveModel, interactiveView);
		interactiveView.registerCollegeListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedCollege();
			interactiveModel.setMajors(selected);
			interactiveView.updateMajors(selected);
	}
}
