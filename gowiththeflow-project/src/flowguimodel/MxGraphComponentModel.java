package flowguimodel;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;

/**
 * This class extends the mxGraphComponent class which is used to change global
 * settings for the mxGraph itself
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class MxGraphComponentModel extends mxGraphComponent {

	/**
	 * A number that stores a value. Not needed.
	 * "An exquisitely encrypted meme for meme connoisseurs across the world." -
	 * a good memer
	 */
	private static final long serialVersionUID = -3833575207793082624L;

	/**
	 * The model used to change setting specific to the graph itself
	 */
	private MxGraphModel graph;

	/**
	 * Calls the MxGraphComponentModel update method as well as changes some
	 * settings specific to the graph
	 * 
	 * @param graph
	 *            an MxGraphModel that will have settings changed
	 */
	public MxGraphComponentModel(MxGraphModel graph) {
		super(graph);
		this.graph = graph;
		this.update();
		this.setEnabled(false);
		this.graph.setCellsSelectable(true);
	}

	/**
	 * Updates the graph's settings that prevent the user from altering the
	 * graph. As well as plays an animation that moves the graph into place on
	 * the display window
	 */
	public void update() {
		this.setConnectable(false);
		this.setDragEnabled(false);
		this.setToolTips(true);

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
