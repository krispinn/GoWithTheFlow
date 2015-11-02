package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class CollegeListener extends ListenerModel implements ListSelectionListener {
	
	public CollegeListener(InteractiveView interactiveView,
			InteractiveModel interactiveModel) {
		super(interactiveView, interactiveModel);
		interactiveView.registerCollegeListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedCollege();
			interactiveModel.setMajors(selected);
	}
}
