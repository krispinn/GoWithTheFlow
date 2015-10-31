package flowguicontroller;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import flowguimodel.GraphModel;
import flowguimodel.ListModel;
import flowguiview.GraphView;
import flowguiview.InteractiveView;

/**
 * Controller used to handle events related to the right panel of the GUI, mainly the drop down list.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowController{
    /** 
     * The model of this MVC
     */
	private GraphModel graphModel;
	
	private ListModel listModel;
	
	private GraphView graphView;
	/** 
	 * The view of this MVC
	 */
	private InteractiveView interactiveView;
	
	private String college;

	public FlowController(GraphModel gModel, ListModel lModel, GraphView gView, InteractiveView iView) {
		this.graphModel = gModel;
		this.listModel = lModel;
		this.graphView = gView;
		this.interactiveView = iView;
	}

}
