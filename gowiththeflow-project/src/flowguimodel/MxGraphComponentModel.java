package flowguimodel;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;

public class MxGraphComponentModel extends mxGraphComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3833575207793082624L;

	private MxGraphModel graph;
	
	public MxGraphComponentModel(MxGraphModel graph) {
		super(graph);
		this.graph = graph;
		this.update();
		this.setEnabled(false);
		this.graph.setCellsSelectable(true);
	}
	
	public void update() {
		this.setConnectable(false);
		this.setDragEnabled(false);
		
		mxHierarchicalLayout layout = new mxHierarchicalLayout(graph);
		layout.setInterRankCellSpacing(100);
		
		// layout using morphing
		graph.getModel().beginUpdate();
		try {
			layout.execute(graph.getDefaultParent());
		} finally {
			mxMorphing morph = new mxMorphing(this, 20, 1.2, 20);
			morph.addListener(mxEvent.DONE, new mxIEventListener() {
				public void invoke(Object arg0, mxEventObject arg1) {
					graph.getModel().endUpdate();
				}
			});
			morph.startAnimation();
		}
	}
}
