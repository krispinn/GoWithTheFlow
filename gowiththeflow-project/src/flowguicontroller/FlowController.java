package flowguicontroller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.GraphModel;
import flowguimodel.ListModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

/**
 * Controller used to handle events related to the right panel of the GUI, mainly the drop down list.
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class FlowController implements MouseListener {
    /** 
     * The model of this MVC
     */
	private GraphModel graphModel;
		
	private FlowView graphView;
	/** 
	 * The view of this MVC
	 */
	private InteractiveView interactiveView;
	
	private String college;

	private mxGraphComponent graphComponent;
	
	private JButton downloadButton;
	
	public FlowController(GraphModel graphModel, FlowView flowView, InteractiveView interactiveView) {
		this.graphModel = graphModel;
		this.graphView = flowView;
		this.interactiveView = interactiveView;
		
		flowView.registerVertexMouseListener(this);
	}
	
	public void setGraphComponent(mxGraphComponent graphComponent) {
		
		this.graphComponent = graphComponent;
	}
	
	public void setDownloadButton(JButton downloadButton) {
		this.downloadButton = downloadButton;
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
