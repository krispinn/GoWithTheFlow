package flowguimodel;

import java.util.Iterator;

import com.mxgraph.model.mxCell;
import com.mxgraph.view.mxGraph;

public class MxGraphModel extends mxGraph {

	private GraphModel graphModel;
	private Object[] listOfVertices; // we have to CREAT since mxGraph only
										// takes in a generic object not our
										// CourseModel

	public MxGraphModel(GraphModel graphModel) {
		super();
		this.graphModel = graphModel;
		this.listOfVertices = new Object[graphModel.getVertices().size()]; // we
																			// initialize
																			// the
																			// size
																			// of
																			// the
																			// listOfVertices
																			// here
																			// (which
																			// will
																			// store
																			// the
																			// generic
																			// versions
																			// of
																			// our
																			// CourseModels)
		this.update(); // we call this method to populate the graph
	}

	public void update() {
		Iterator<CourseModel> nodeIterator = graphModel.getVertices().values().iterator(); // loop
																							// through
																							// the
																							// hash
																							// map
																							// for
																							// courses
		Iterator<DirectedEdgeModel> edgeIterator = graphModel.getEdges().iterator(); // loop
																						// through
																						// set
																						// for
																						// edges
																						// between
																						// courses
		int nodeCount = 0; // counter used to place a 'CourseModel' into the
							// array
		while (nodeIterator.hasNext()) {
			CourseModel current = nodeIterator.next();
			String subjectNumber = current.getSubjectNumber(); // this is the
																// name
																// displayed on
																// each box of
																// the graph
			listOfVertices[nodeCount++] = this.insertVertex(this.getDefaultParent(), null, subjectNumber, 0, 0, 80, 80,
					"fillColor=white"); // the assignment returns an object
										// which is initialized to out desired
										// properties
		}
		while (edgeIterator.hasNext()) { // this loop runs until all edges have
											// been made
			DirectedEdgeModel edge = edgeIterator.next(); // this gets an edge
															// model
			this.insertEdge(this.getDefaultParent(), null, "", listOfVertices[edge.getFromNum()],
					listOfVertices[edge.getToNum()]); // here we create the
														// actual graph using
														// the indexes provided
														// from the edgeModel
														// (to get the course in
														// name/model in
														// listOfVertices)
		}
	}

	@Override
	public String getToolTipForCell(Object cell) {
		try {
			if (cell != null && cell instanceof mxCell) {
				String tooltip = graphModel.returnCourseModel(((mxCell) cell).getValue().toString());
				tooltip = tooltip.replaceAll("(\\r\\n|\\n)", "<br>");
				return ("<html> <p width=\"400\">" + tooltip + "</p></html>");
			} else {
				return "";
			}
		} catch (NullPointerException e) {
			// deals with the error that shows up when the user hovers on an
			// edge
			return "";
		}
	}
}
