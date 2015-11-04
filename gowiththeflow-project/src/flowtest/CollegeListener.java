package flowtest;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

public class CollegeListener  implements MenuListener {
	
	private InteractiveView interactiveView;
	private InteractiveModel interactiveModel;
	private FlowView view;

	public CollegeListener(InteractiveModel interactiveModel, InteractiveView interactiveView, FlowView view) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		this.view = view;
		interactiveView.registerCollegeListener(this);
		view.registerCollegeListener(this);
		
	}

	public void valueChanged(MenuListener e) {
			String selected = interactiveView.getSelectedCollege();
			interactiveModel.setMajors(selected);
			interactiveView.updateMajors(selected);
	}

	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void menuSelected(MenuEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
