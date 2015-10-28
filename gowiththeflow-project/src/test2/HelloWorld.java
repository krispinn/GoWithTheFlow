package test2;

import javax.swing.JFrame;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxFastOrganicLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource.mxIEventListener;
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
		mxPoint point = new mxPoint();
		point.setX(683);
		point.setY(0);
		graph.setOrigin(point);
		graph.getModel().beginUpdate();
		try {
			Object intro1 = graph.insertVertex(parent, null, "1063\nIntro 1", point.getX(), point.getY(), 80, 30);
			Object intro2 = graph.insertVertex(parent, null, "1713/1\nIntro 2", 240, 150, 80, 30);
			Object datas = graph.insertVertex(parent, null, "2123/1\nDataS", 240, 150, 80, 30);
			Object discm = graph.insertVertex(parent, null, "2233\nDiscM", 240, 150, 80, 30);
			Object mfound = graph.insertVertex(parent, null, "3333\nMFound", 240, 150, 80, 30);
			Object algo = graph.insertVertex(parent, null, "3343/1\nAlgo", 240, 150, 80, 30);
			Object sysp = graph.insertVertex(parent, null, "3423/1\nSysP", 240, 150, 80, 30);
			Object appp = graph.insertVertex(parent, null, "3443\nAppP", 240, 150, 80, 30);
			Object org = graph.insertVertex(parent, null, "3843/1\nOrg", 240, 150, 80, 30);
			Object plang = graph.insertVertex(parent, null, "3723\nPLang", 240, 150, 80, 30);
			Object os = graph.insertVertex(parent, null, "3733/1\nOS", 240, 150, 80, 30);
			Object arch = graph.insertVertex(parent, null, "3853/1\nArch", 240, 150, 80, 30);

			graph.insertEdge(parent, null, "", intro1, intro2);
			graph.insertEdge(parent, null, "", intro2, datas);
			graph.insertEdge(parent, null, "", intro2, discm);
			graph.insertEdge(parent, null, "", intro2, mfound);
			graph.insertEdge(parent, null, "", datas, algo);
			graph.insertEdge(parent, null, "", datas, org);
			graph.insertEdge(parent, null, "", datas, appp);
			graph.insertEdge(parent, null, "", datas, sysp);
			graph.insertEdge(parent, null, "", discm, algo);
			graph.insertEdge(parent, null, "", discm, plang);
			graph.insertEdge(parent, null, "", mfound, algo);
			graph.insertEdge(parent, null, "", org, arch);
			graph.insertEdge(parent, null, "", org, os);
			graph.insertEdge(parent, null, "", appp, plang);
			graph.insertEdge(parent, null, "", appp, os);
			graph.insertEdge(parent, null, "", sysp, arch);
			graph.insertEdge(parent, null, "", sysp, os);
/*
			graph.insertEdge(parent, null, "Edge", v1, v2);
			graph.insertEdge(parent, null, "Edge", v1, v3);
			graph.insertEdge(parent, null, "Edge", v2, v4);
			graph.insertEdge(parent, null, "Edge", v2, v5);
			graph.insertEdge(parent, null, "Edge", v3, v6);

			// define layout
			mxCompactTreeLayout Layout = new mxCompactTreeLayout(graph);

			Layout.setNodeDistance(15);
			Layout.setLevelDistance(40);
			Layout.setHorizontal(false);
			// layout graph
			Layout.execute(graph.getDefaultParent());
*/
		    // define layout

		} finally {
			graph.getModel().endUpdate();
		}

		mxGraphComponent graphComponent = new mxGraphComponent(graph);
		getContentPane().add(graphComponent);
		
	    mxCompactTreeLayout Layout = new mxCompactTreeLayout(graph);
	    
		Layout.setNodeDistance(15);
		Layout.setLevelDistance(40);
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
	                // fitViewport();
	            }

	        });

	        morph.startAnimation();
	    }
	}

	public static void main(String[] args) {
		HelloWorld frame = new HelloWorld();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// need to modify automatically for other display option.
		frame.setSize(1366, 768);
		frame.setVisible(true);
	}

}
