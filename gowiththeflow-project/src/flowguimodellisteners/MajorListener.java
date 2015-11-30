package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

/**
 * This class deals with user interaction in the list of Majors in the interactive view.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 *
 */
public class MajorListener implements ListSelectionListener {

	/**
	 * The Interactive view's view
	 */
	private InteractiveView interactiveView;

	/**
	 * The interactive view's model
	 */
	private InteractiveModel interactiveModel;

	/**
	 * The constructor, calls the registerMajorListener method.
	 * 
	 * @param interactiveModel
	 *            The interactive view's model
	 * @param interactiveView
	 *            The interactive view's view
	 */
	public MajorListener(InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		interactiveView.registerMajorListener(this);
	}

	/**
	 * If the list of majors in the interactive view is changed this method changes the view and
	 * model according to it.
	 */
	public void valueChanged(ListSelectionEvent e) {
		String selected = interactiveView.getSelectedMajor();
		interactiveModel.setSelectedMajor(selected);
		System.out.println(selected);
	}

}
