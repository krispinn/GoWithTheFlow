package flowguiview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.MxGraphComponentModel;
import flowguimodellisteners.VertexListener;

public class FlowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private mxGraphComponent graphComponent;
		
	public FlowView(InteractiveView interactiveModel, final MxGraphComponentModel graphComponent) throws Exception {
		
		super("GoWithTheFlow");

		this.graphComponent = graphComponent;

		this.getContentPane().add(graphComponent);
		this.getContentPane().add(interactiveModel, BorderLayout.EAST);

		this.setSize(1366, 768);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setGraphComponent(mxGraphComponent graphComponent) {

		this.graphComponent = graphComponent;
		
	}
	
	public void registerVertexMouseListener(VertexListener listener) {
		graphComponent.getGraphControl().addMouseListener(listener);
	}
	
}
