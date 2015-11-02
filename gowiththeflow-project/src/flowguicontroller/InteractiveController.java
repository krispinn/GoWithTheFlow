package flowguicontroller;

import flowguimodel.InteractiveModel;
import flowguimodellisteners.CollegeListener;
import flowguimodellisteners.DownloadListener;
import flowguimodellisteners.MajorListener;
import flowguiview.InteractiveView;

public class InteractiveController {

	public InteractiveView interactiveView;
	public InteractiveModel interactiveModel;

	public InteractiveController(InteractiveView interactiveView,
			InteractiveModel interactiveModel) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		
		DownloadListener downloadListener = new DownloadListener(interactiveView, interactiveModel);
		CollegeListener collegeListener = new CollegeListener(interactiveView, interactiveModel);
		MajorListener majorListener = new MajorListener(interactiveView, interactiveModel);
		
	}
}
