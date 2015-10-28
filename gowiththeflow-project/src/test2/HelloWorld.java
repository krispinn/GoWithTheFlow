package test2;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;

public class HelloWorld extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public HelloWorld() {
		super("Hello, World!");

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		mxPoint point = new mxPoint(683,0);

		graph.getModel().beginUpdate();
		try {
			Object v1 = graph.insertVertex(parent, null, "1!", point.getX(), point.getY(), 80, 30);
			Object v2 = graph.insertVertex(parent, null, "2!", 240, 150, 80, 30);
			Object v3 = graph.insertVertex(parent, null, "3!", 240, 150, 80, 30);
			Object v4 = graph.insertVertex(parent, null, "4!", 240, 150, 80, 30);
			Object v5 = graph.insertVertex(parent, null, "5!", 240, 150, 80, 30);
			Object v6 = graph.insertVertex(parent, null, "6!", 240, 150, 80, 30);

			graph.insertEdge(parent, null, "Edge", v1, v2);
			graph.insertEdge(parent, null, "Edge", v1, v3);
			graph.insertEdge(parent, null, "Edge", v2, v4);
			graph.insertEdge(parent, null, "Edge", v2, v5);
			graph.insertEdge(parent, null, "Edge", v3, v6);

			// define layout
			mxCompactTreeLayout Layout = new mxCompactTreeLayout(graph);
			Layout.setEdgeRouting(false);
			Layout.setNodeDistance(50);
			Layout.setHorizontal(false);
			// layout graph
			Layout.execute(graph.getDefaultParent());

		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
	}

	public static void main(String[] args) {
		HelloWorld frame = new HelloWorld();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// need to modify automatically for other display option.
		frame.setSize(1366, 768);
		frame.setVisible(true);
	}

}
