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

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
