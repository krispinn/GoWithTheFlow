package test;

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

import flowmodel.CourseModel;
import flowmodel.DirectedEdgeModel;
import flowmodel.GraphModel;

public class GenerateGraph extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public GenerateGraph() throws Exception {

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
			}

			while (edgeIterator.hasNext()) {
				DirectedEdgeModel e = edgeIterator.next();
				graph.insertEdge(parent, null, "", list[e.getFrom()], list[e.getTo()]);
			}

		} finally {
			graph.getModel().endUpdate();
		}


		
		mxGraphComponent graphComponent = new mxGraphComponent(graph);
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
	}
}
