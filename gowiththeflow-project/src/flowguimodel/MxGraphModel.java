package flowguimodel;

import java.util.Iterator;

import com.mxgraph.view.mxGraph;

public class MxGraphModel extends mxGraph{
	
	private GraphModel graphModel;
	private Object[] listOfVertices;
	
	public MxGraphModel(GraphModel graphModel) {
		this.graphModel = graphModel;
		this.listOfVertices = new Object[graphModel.getVertices().size()];
		this.update();
	}
	
	public void update() {
		Iterator<CourseModel> nodeIterator = graphModel.getVertices().values().iterator();
		Iterator<DirectedEdgeModel> edgeIterator = graphModel.getEdges().iterator();
		int nodeCount = 0;
		while (nodeIterator.hasNext()) {
			CourseModel current = nodeIterator.next();
			String subjectNumber = current.getSubjectNumber();
			listOfVertices[nodeCount++] = this.insertVertex(this.getDefaultParent(), null, subjectNumber, 0, 0, 80, 80,
					"fillColor=white");
		}
		while (edgeIterator.hasNext()) {
			DirectedEdgeModel e = edgeIterator.next();
			this.insertEdge(this.getDefaultParent(), null, "", listOfVertices[e.getFromNum()], listOfVertices[e.getToNum()]);
		}
	}
}
