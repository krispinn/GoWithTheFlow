package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

public class MajorListener extends FlowController implements ListSelectionListener {


	public MajorListener(GraphModel graphModel, FlowView graphView,
			InteractiveModel interactiveModel, InteractiveView interactiveView) {
		super(graphModel, graphView, interactiveModel, interactiveView);
		interactiveView.registerMajorListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedMajor();
			interactiveModel.setSelectedMajor(selected);
			System.out.println(selected);
	}
}
