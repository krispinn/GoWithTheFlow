package flowguimodellisteners;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public abstract class ListenerModel {

	public InteractiveView interactiveView;
	public InteractiveModel interactiveModel;

	public ListenerModel(InteractiveView interactiveView,
			InteractiveModel interactiveModel) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
	}
}
