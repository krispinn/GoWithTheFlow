package flowguimodellisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class RecitationListener implements ActionListener {

	private InteractiveView interactiveView;
	private InteractiveModel interactiveModel;
	
	public RecitationListener(InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		interactiveView.registerRecitationButton(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
