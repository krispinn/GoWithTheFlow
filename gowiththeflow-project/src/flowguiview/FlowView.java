package flowguiview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;

import flowguicontroller.FlowController;
import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;

public class FlowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	private InteractiveModel interactiveModel;
	
	private mxGraphComponent graphComponent;
		
	public FlowView(InteractiveModel interactiveModel, final MxGraphComponentModel graphComponent) throws Exception {
		this.interactiveModel = interactiveModel;
		this.graphComponent = graphComponent;

		
		addJPanel();
		addGraph();
		setSettings();
		
	}
	
	public void addGraph() {
		this.getContentPane().add(graphComponent);
	}
	
	public void addJPanel() {
		this.getContentPane().add(interactiveModel, BorderLayout.EAST);
	}
	
	public void setSettings() {
		this.setSize(1366, 768);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void registerVertexMouseListener(FlowController controller) {
		graphComponent.getGraphControl().addMouseListener(controller);
		controller.setGraphComponent(graphComponent);
	}
	
}
