package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class MajorListener extends ListenerModel implements ListSelectionListener {
	
	public MajorListener(InteractiveView interactiveView,
			InteractiveModel interactiveModel) {
		super(interactiveView, interactiveModel);
		interactiveView.registerMajorListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedMajor();
			interactiveModel.setSelectedMajor(selected);
			System.out.println(selected);
	}
}
