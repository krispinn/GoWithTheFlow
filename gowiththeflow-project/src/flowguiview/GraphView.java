package flowguiview;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.MxGraphComponentModel;
import flowguimodellisteners.VertexListener;

/**
 * Displays the graph.
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas
 */
public class GraphView extends JPanel {

	/**
	 * The model for the graph.
	 */
	private mxGraphComponent graphComponent;

	/**
	 * 
	 * 
	 * @param graphComponent
	 */
	public GraphView(MxGraphComponentModel graphComponent) {
		this.graphComponent = graphComponent;
		this.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Courses"),
						BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(graphComponent);
	}

	/**
	 * 
	 * 
	 * @param listener
	 */
	public void registerVertexMouseListener(VertexListener listener) {
		graphComponent.getGraphControl().addMouseListener(listener);
	}

	/**
	 * 
	 * 
	 * @param graphComponent
	 */
	public void setGraphComponent(final MxGraphComponentModel graphComponent) {
		this.graphComponent = graphComponent;
	}

}
