package flowguimodel;

import java.util.Iterator;
import java.util.Map;

import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

/**
 * MxGraphModel contains methods for creating and using an MxGraphModel object
 * This class can create a model using a GraphModel, update the called model, as
 * well as overrides mxgraph's getToolTip method to display course information
 * via tool tips
 * 
 * @author Bilal Siddiqui, Mostafa Dabas, Danny Tsang, Miguel Cardenas, Jason
 *         Blig
 *
 */
public class MxGraphModel extends mxGraph {

	/**
	 * Contains an ArrayList, and HashMaps for the current major
	 */
	private GraphModel graphModel;

	/**
	 * Contains a list of the model's current vertices
	 */
	private Object[] listOfVertices;
	/*
	 * we have to CREATE since mxGraph only takes in a generic object not our
	 * CourseModel
	 */

	/**
	 * The MxGraphModel constructor, takes in a GraphModel and uses its vertices
	 * to assign a size to listOfVertices and updates the MxGraphModel
	 * 
	 * @param graphModel
	 *            the GraphModel to be used by the MxGraphModel
	 */
	public MxGraphModel(GraphModel graphModel) {
		super();
		this.graphModel = graphModel;
		
		Map<String, Object> style = this.getStylesheet().getDefaultVertexStyle();
	    style.put(mxConstants.STYLE_ROUNDED, true);

		/*
		 * we initialize the size of the listOfVertices here (which will store
		 * the generic versions of our CourseModels)
		 */
		this.listOfVertices = new Object[graphModel.getVertices().size()];

		this.update(); // we call this method to populate the graph
	}

	/**
	 * Updates the MxGraphModel. listOfVertices is populated with the values
	 * from the graphModel, this will effectively change what is displayed in
	 * the end graph. Based on data from the graphModel, it also creates the
	 * edges between the vertices.
	 */
	public void update() {

		// loop through the has map for courses
		Iterator<CourseModel> nodeIterator = graphModel.getVertices().values().iterator();

		// loop through set for edges between courses
		Iterator<DirectedEdgeModel> edgeIterator = graphModel.getEdges().iterator();

		// counter used to place a 'CourseModel' into the array
		int nodeCount = 0;

		while (nodeIterator.hasNext()) {
			CourseModel current = nodeIterator.next();

			// this is the name displayed on each box of the graph
			String subjectNumber = current.getSubjectNumber();

			/*
			 * the assignment returns an object which is initialized to out
			 * desired properties
			 */
			listOfVertices[nodeCount++] = this.insertVertex(this.getDefaultParent(), null, subjectNumber, 0, 0, 80, 40,
					"ROUNDED;fillColor=white");
		}

		// this loop runs until all edges have been made
		while (edgeIterator.hasNext()) {

			// this gets an edge model
			DirectedEdgeModel edge = edgeIterator.next();

			/*
			 * here we create the actual graph using the indexes provided from
			 * the edgeModel (to get the course in name/model in listOfVertices)
			 */
			this.insertEdge(this.getDefaultParent(), null, "", listOfVertices[edge.getFromNum()],
					listOfVertices[edge.getToNum()]);
		}
	}

	/**
	 * Displays the course information for the hovered on course instead of just
	 * the course number
	 */
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

			/*
			 * deals with the error that shows up when the user hovers on an
			 * edge
			 */
			return "";
		}
	}
}
