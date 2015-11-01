package flowguicontroller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.ListModel;
import flowguiview.FlowView;

/**
 * Controller used to handle events related to the right panel of the GUI, mainly the drop down list.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowController implements MouseListener {
    /** 
     * The model of this MVC
     */
	private GraphModel graphModel;
	
	private ListModel listModel;
	
	private FlowView graphView;
	/** 
	 * The view of this MVC
	 */
	private InteractiveModel interactiveView;
	
	private String college;

	private mxGraphComponent graphComponent;
	
	public FlowController(GraphModel graphModel, ListModel listModel, FlowView flowView, InteractiveModel interactiveModel) {
		this.graphModel = graphModel;
		this.listModel = listModel;
		this.graphView = flowView;
		this.interactiveView = interactiveModel;
		
		flowView.registerVertexMouseListener(this);
	}
	
	public void setGraphComponent(mxGraphComponent graphComponent) {
		
		this.graphComponent = graphComponent;
	}

	public void mouseClicked(MouseEvent e) {
		Object cell = graphComponent.getCellAt(e.getX(), e.getY());
		
		if (cell != null && cell instanceof mxCell) {
			String something = ((mxCell)cell).getValue().toString();
			String desc = graphModel.getVertexIndex(something).getDescription();
			System.out.println(desc);
			
		}
	}

	public void mouseEntered(MouseEvent e) {
		// Do nothing
		
	}

	public void mouseExited(MouseEvent e) {
		// Do nothing
		
	}

	public void mousePressed(MouseEvent e) {
		// Do nothing
		
	}

	public void mouseReleased(MouseEvent e) {
		// Do nothing
		
	}

}
