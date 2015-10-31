package flowguiview;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.view.mxGraph;

import flowguicontroller.FlowController;
import flowguimodel.CourseModel;
import flowguimodel.DirectedEdgeModel;
import flowguimodel.GraphModel;
import flowtest.ListOfCourses;

public class GraphView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	private InteractiveView interactiveView;
	private mxGraphComponent graphComponent;
	
	public GraphView(InteractiveView interactiveView) throws Exception {

		this.interactiveView = interactiveView;
		final mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		ListOfCourses test = new ListOfCourses("data/courselists/engineering_electricalcomputerengineering.txt");
		ArrayList<CourseModel> temp = test.read();
		GraphModel g = new GraphModel(temp);
		Object[] list = new Object[g.getNodes().size()];

		graph.getModel().beginUpdate();
		try {
			Iterator<CourseModel> nodeIterator = g.getNodes().values().iterator();
			Iterator<DirectedEdgeModel> edgeIterator = g.getEdges().iterator();
			int nodeCount = 0;

			while (nodeIterator.hasNext()) {
				CourseModel current = nodeIterator.next();
				String subjectNumber = current.getSubNum();
				list[nodeCount++] = graph.insertVertex(parent, null, subjectNumber, 0, 0, 80, 80,
						"fillColor=white");
				//((Object) graph.getSelectionModel()).addMouseMotionListener();
			}

			while (edgeIterator.hasNext()) {
				DirectedEdgeModel e = edgeIterator.next();
				graph.insertEdge(parent, null, "", list[e.getFrom()], list[e.getTo()]);
			}

		} finally {
			graph.getModel().endUpdate();
		}
		
		graphComponent = new mxGraphComponent(graph);
		//graphComponent.getGraphControl().addMouseListener(mouseListener);
		
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
