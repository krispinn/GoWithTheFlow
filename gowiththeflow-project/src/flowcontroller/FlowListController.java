package flowcontroller;
import java.awt.Color;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowmodel.FlowModel;
import flowview.InteractiveView;

/**
 * Controller used to handle events related to the right panel of the GUI, mainly the drop down list.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowListController implements ListSelectionListener {
    /** 
     * The model of this MVC
     */
	private FlowModel model;
	
	/** 
	 * The view of this MVC
	 */
	private InteractiveView view;

	public FlowListController(FlowModel model, InteractiveView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Update the model when the user selects a color, and repaint the 
	 * window.
	 */
	public void valueChanged(ListSelectionEvent event) {
		Color color = view.getSelectedColor();
		model.setSelectedColor(color);
		view.repaint();
	}
	
	/*public void actionPerformed(ActionEvent e) {
		
		
	}*/
}
