package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class CollegeListener  implements ListSelectionListener {
	
	private InteractiveView interactiveView;
	private InteractiveModel interactiveModel;

	public CollegeListener(InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		interactiveView.registerCollegeListener(this);
	}

	public void valueChanged(ListSelectionEvent e) {
			String selected = interactiveView.getSelectedCollege();
			interactiveModel.setMajors(selected);
			interactiveView.updateMajors(selected);
	}
}
