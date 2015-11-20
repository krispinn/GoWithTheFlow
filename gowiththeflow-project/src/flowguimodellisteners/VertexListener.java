package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;

import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;
import flowguimodel.MxGraphModel;
import flowguiview.GraphView;
import flowguiview.InteractiveView;

/**
 * 
 * @author zli781
 *
 */

public class VertexListener implements MouseListener {

	/**
	 * 
	 */
	private MxGraphComponentModel graphComponent;
	
	/**
	 * 
	 */
	private GraphModel graphModel;
	
	/**
	 * 
	 */
	private InteractiveView interactiveView;
	
	/**
	 * 
	 */
	private InteractiveModel interactiveModel;
	
	/**
	 * 
	 */
	private MxGraphModel mxg;
	
	/**
	 * 
	 */
	private GraphView graphView;

	
	public VertexListener(GraphModel graphModel, InteractiveModel interactiveModel,
			InteractiveView interactiveView, MxGraphComponentModel graphComponent,
			GraphView graphView, MxGraphModel mxg) {
		this.graphComponent = graphComponent;
		this.graphModel = graphModel;
		this.interactiveModel = interactiveModel;
		this.interactiveView = interactiveView;
		this.mxg = mxg;
		this.graphView = graphView;

		graphView.registerVertexMouseListener(this);
	}

	
	public void mouseClicked(MouseEvent e) {
		Object cell = graphComponent.getCellAt(e.getX(), e.getY());

		Object[] kids = mxg.getChildVertices(mxg.getDefaultParent());

		Object[] cells = mxg.getChildVertices(mxg.getDefaultParent());
		//Object[] kids = mxg.getChildVertices(cell);

		
		for (Object o : kids)
			mxg.setCellStyles(mxConstants.STYLE_FILLCOLOR, "white", new Object[] { o });

		
		// NON WORKING CHANGE COLOR OF CHILDREN/PARENTS 
		Object[] childrenCells = mxg.getConnections(mxg.getConnections(cell)); 
		for (Object f : childrenCells)
			mxg.setCellStyles(mxConstants.STYLE_FILLCOLOR, "add8e6", new Object[]{f});
		

		mxg.setCellStyles(mxConstants.STYLE_FILLCOLOR, "add8e6", new Object[] { cell });

		graphComponent.refresh();

		if (cell != null && cell instanceof mxCell) {
			String info = graphModel.returnCourseModel(((mxCell) cell).getValue().toString());
			interactiveModel.setCourseInformation(info);
			interactiveView.updateJTextArea(info);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// do nothing
	}

	/**
	 * Unutilized method
	 */
	public void mouseExited(MouseEvent e) {
		// do nothing
	}

	/**
	 * Unutilized method
	 */
	public void mousePressed(MouseEvent e) {
		// do nothing
	}

	/**
	 * Unutilized method
	 */
	public void mouseReleased(MouseEvent e) {
		// do nothing
	}

}