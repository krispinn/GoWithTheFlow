package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class MajorListener implements ListSelectionListener {

	private InteractiveView interactiveView;
	private InteractiveModel interactiveModel;
	
	public MajorListener(InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		interactiveView.registerMajorListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedMajor();
			interactiveModel.setSelectedMajor(selected);
			System.out.println(selected);
	}
}
