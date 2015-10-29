package testdannybilal;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxConstants;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
import com.mxgraph.util.mxPoint;
import com.mxgraph.view.mxGraph;

public class NewTestDriver extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	public NewTestDriver() throws Exception {

		mxGraph graph = new mxGraph();
		Object parent = graph.getDefaultParent();
		mxPoint point = new mxPoint(683,0);

		ListOfCourses test = new ListOfCourses("data/courselists/sciences_computerscience.txt");
		ArrayList<Course> temp = test.read();
		Graph g = new Graph(temp);
		Object[] list = new Object[g.getNodes().size()];
		
		graph.getModel().beginUpdate();
		try {
			Iterator<Course> nodeIterator = g.getNodes().values().iterator();
			Iterator<DirectedEdge> edgeIterator = g.getEdges().iterator();
			int nodeCount = 0;
			
			
			
			while(nodeIterator.hasNext()) {
				Course current = nodeIterator.next();
				String subjectNumber = current.getSubNum();
				list[nodeCount++] = graph.insertVertex(parent, null, subjectNumber, 1, 1, 80, 80, "fillColor=white");
			}
						
			while(edgeIterator.hasNext()) {
				DirectedEdge e = edgeIterator.next();
				graph.insertEdge(parent, null, "", list[e.getFrom()], list[e.getTo()]);
			}
			
		    // define layout

		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		
	    mxCompactTreeLayout Layout = new mxCompactTreeLayout(graph);
	    
		Layout.setNodeDistance(10);
		Layout.setLevelDistance(100);
		Layout.setHorizontal(false);
		Layout.setEdgeRouting(false);	
		
	    // layout using morphing
	    graph.getModel().beginUpdate();
	    try {
	        Layout.execute(graph.getDefaultParent());
	    } finally {
	        mxMorphing morph = new mxMorphing(graphComponent, 20, 1.2, 20);

	        morph.addListener(mxEvent.DONE, new mxIEventListener() {

	            @Override
	            public void invoke(Object arg0, mxEventObject arg1) {
	                graph.getModel().endUpdate();
	                //fitViewport();
	            }

	        });
	        
	        morph.startAnimation();
	    }
	    
	    
	    
	    /*
	    Map<String, Object> style = graph.getStylesheet().getDefaultEdgeStyle();
	    style.put(mxConstants.STYLE_ROUNDED, true);
	    style.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ENTITY_RELATION);
		*/
	}

	public static void main(String[] args) throws Exception {
		NewTestDriver frame = new NewTestDriver();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// need to modify automatically for other display option.
		frame.setSize(1366, 768);
		frame.setVisible(true);
	}

}
