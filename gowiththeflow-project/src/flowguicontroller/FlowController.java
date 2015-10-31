package flowguicontroller;
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
public class FlowController implements ListSelectionListener {
    /** 
     * The model of this MVC
     */
	private GraphModel gModel;
	
	private ListModel lModel;
	
	private GraphView gView;
	/** 
	 * The view of this MVC
	 */
	private InteractiveView iView;

	public FlowController(GraphModel gModel, ListModel lModel, GraphView gView, InteractiveView iView) {
		this.gModel = gModel;
		this.lModel = lModel;
		this.gView = gView;
		this.iView = iView;
	}

	public void valueChanged(ListSelectionEvent event) {
		String selected = event.getSource().toString();
		System.out.println(selected);
	}
	


}
