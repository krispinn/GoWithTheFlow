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
 * This listeners listens for mouse clicks on the graphView. Displays a course description in a
 * description box (located in the Interactive View) if the user clicks on a vertex of the graph.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 */
public class VertexListener implements MouseListener {

	/**
	 * The graph's mxGraphComponent
	 */
	private MxGraphComponentModel graphComponent;

	/**
	 * The graph's model
	 */
	private GraphModel graphModel;

	/**
	 * The Interactive View's view This is the JPanel used for user selection of college/major
	 */
	private InteractiveView interactiveView;

	/**
	 * The Interactive View's model
	 */
	private InteractiveModel interactiveModel;

	/**
	 * The graph's mxGraph model
	 */
	private MxGraphModel mxg;

	/**
	 * The graph's view
	 */
	private GraphView graphView;

	/**
	 * The constructor. Calls the registerVertexMouseListener method.
	 * 
	 * @param graphModel
	 *            The graph's model.
	 * @param interactiveModel
	 *            The Interactive View's model
	 * @param interactiveView
	 *            The Interactive View's view
	 * @param graphComponent
	 *            The graph's mxGraphComponent
	 * @param graphView
	 *            The graph's view
	 * @param mxg
	 *            The graph's mxGraph model
	 */
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

	/**
	 * On mouse click, checks if the mouse is over a vertex (node). If so, information from that
	 * vertex is taken and is displayed in a description box located in the Interactive view.
	 */
	public void mouseClicked(MouseEvent e) {
		Object[] allNodes = mxg.getChildCells(mxg.getDefaultParent());
		Object clickedNode = graphComponent.getCellAt(e.getX(), e.getY());
		Object[] kids = mxg.getChildCells(clickedNode);

		System.out.println("This is the number of c");
		for (Object node : allNodes)
			mxg.getModel().setStyle(node, "fillColor=#FFFFFF");
			//mxg.setCellStyles(mxConstants.STYLE_FILLCOLOR, "add8e6", new Object[] { node });
		
		mxg.getModel().setStyle(clickedNode, "fillColor=add8e6");
		graphComponent.refresh();

		/*
		 * //NON WORKING CHANGE COLOR OF CHILDREN/PARENTS for (Object f : kids)
		 * mxg.getModel().setStyle(f, "fillColor=#00FF00");
		 */

		if (clickedNode != null && clickedNode instanceof mxCell) {
			String info = graphModel
					.returnCourseModel(((mxCell) clickedNode).getValue().toString());
			interactiveModel.setCourseInformation(info);
			interactiveView.updateJTextArea(info);
		}
	}

	/**
	 * Doesn't do anything if the mouse enters the window
	 */
	public void mouseEntered(MouseEvent e) {
		// do nothing
	}

	/**
	 * Doesn't do anything if the mouse exits the window
	 */
	public void mouseExited(MouseEvent e) {
		// do nothing
	}

	/**
	 * Doesn't do anything on mouse press
	 */
	public void mousePressed(MouseEvent e) {
		// do nothing
	}

	/**
	 * Doesn't do anything on mouse release
	 */
	public void mouseReleased(MouseEvent e) {
		// do nothing
	}

}
