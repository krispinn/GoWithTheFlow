package flowguiview;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.MxGraphComponentModel;
import flowguimodellisteners.VertexListener;

public class GraphView extends JPanel{

	private mxGraphComponent graphComponent;

	public GraphView(MxGraphComponentModel graphComponent) {
		this.graphComponent = graphComponent;
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Courses"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(graphComponent);
	}
	
	public void registerVertexMouseListener(VertexListener listener) {
		graphComponent.getGraphControl().addMouseListener(listener);
	}
	
	
	public void setGraphComponent(final MxGraphComponentModel graphComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//instance = new FlowView(interactiveView, graphComponent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
