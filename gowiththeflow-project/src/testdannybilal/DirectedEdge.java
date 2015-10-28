package testdannybilal;

public class DirectedEdge {

	private Course from;
	private Course to;
	
	public DirectedEdge(Course from, Course to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public String toString() {
		return "EDGE: From " + from.getSubNum() + " to " + to.getSubNum();
	}
	
}
