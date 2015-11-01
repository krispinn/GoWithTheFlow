package flowguiview;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;

import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.MxGraphModel;

public class GraphView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	private mxGraphComponent graphComponent;
	
	public GraphView(InteractiveView interactiveView, final MxGraphModel graph) throws Exception {
						
		graphComponent = new mxGraphComponent(graph);
		
		getContentPane().add(graphComponent);
		graphComponent.setConnectable(false);
		graphComponent.setDragEnabled(false);
		
		// mxCompactTreeLayout Layout = new mxCompactTreeLayout(graph);
		mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
		layout.setInterRankCellSpacing(100);
		
		// layout using morphing
		graph.getModel().beginUpdate();
		try {
			layout.execute(graph.getDefaultParent());
		} finally {
			mxMorphing morph = new mxMorphing(graphComponent, 20, 1.2, 20);
			morph.addListener(mxEvent.DONE, new mxIEventListener() {
				public void invoke(Object arg0, mxEventObject arg1) {
					graph.getModel().endUpdate();
				}
			});
			morph.startAnimation();
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(interactiveView, BorderLayout.EAST);
		this.setSize(1366, 768);
		this.setVisible(true);
		
	}
	
	public void register(FlowController controller) {
		graphComponent.getGraphControl().addMouseListener(controller);
		
		// send the controller the graphComponent
		controller.setGraphComponent(graphComponent);
	}
	
}
