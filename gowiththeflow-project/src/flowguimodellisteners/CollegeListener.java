package flowguimodellisteners;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

/**
 * This class can listen to the list of colleges of study in the interactive view and updates that
 * list's view and model based off of user interaction.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 *
 */
public class CollegeListener implements ListSelectionListener {

	/**
	 * The Interactive view
	 */
	private InteractiveView interactiveView;

	/**
	 * The Interactive view's model
	 */
	private InteractiveModel interactiveModel;

	/**
	 * Constructs a college listener by calling the registerCollegeListener method.
	 * 
	 * @param interactiveModel
	 *            The Interactive view's model
	 * @param interactiveView
	 *            The Interactive view
	 */
	public CollegeListener(InteractiveModel interactiveModel, InteractiveView interactiveView) {
		this.interactiveView = interactiveView;
		this.interactiveModel = interactiveModel;
		interactiveView.registerCollegeListener(this);
	}

	/**
	 * Detects a change in the interactive list and updates the interactive view's information.
	 */
	public void valueChanged(ListSelectionEvent e) {
		String selected = interactiveView.getSelectedCollege();
		interactiveModel.setMajors(selected);
		interactiveView.updateMajors(selected);
	}

}
