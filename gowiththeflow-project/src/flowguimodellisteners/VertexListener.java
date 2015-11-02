package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

public class VertexListener extends FlowController implements MouseListener {

	private mxGraphComponent graphComponent;
	private GraphModel graphModel;
	private InteractiveView interactiveView;

	public VertexListener(GraphModel graphModel, FlowView graphView, InteractiveModel interactiveModel,
			InteractiveView interactiveView, mxGraphComponent graphComponent) {
		super(graphModel, graphView, interactiveModel, interactiveView);
		this.graphComponent = graphComponent;
		this.graphModel = graphModel;
		this.interactiveView = interactiveView;
		graphView.registerVertexMouseListener(this);
	}

	public void mouseClicked(MouseEvent e) {
		Object cell = graphComponent.getCellAt(e.getX(), e.getY());

		if (cell != null && cell instanceof mxCell) {
			String something = ((mxCell) cell).getValue().toString();
			String info = graphModel.returnCourseModel(something);
			// System.out.println(info);
			interactiveModel.setCourseInformation(info);
			interactiveView.updateJTextArea(info);
		}

	}

	public void mouseEntered(MouseEvent e) {
		// do nothing

	}

	public void mouseExited(MouseEvent e) {
		// do nothing

	}

	public void mousePressed(MouseEvent e) {
		// do nothing

	}

	public void mouseReleased(MouseEvent e) {
		// do nothing

	}

}
