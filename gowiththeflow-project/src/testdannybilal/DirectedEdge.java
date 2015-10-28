package testdannybilal;

public class DirectedEdge {

	private String direction;
	private Course from;
	private Course to;
	
	public DirectedEdge(Course from, Course to) {
		this.from = from;
		this.to = to;
		direction = from.getSubNum() + " to " + to.getSubNum();
	}
	
	
	
}
