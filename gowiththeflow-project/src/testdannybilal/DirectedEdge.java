package testdannybilal;

public class DirectedEdge {

	private Course from;
	private Course to;
	private int fromNum;
	private int toNum;
	
	public DirectedEdge(Course from, Course to, int fromNum, int toNum) {
		this.from = from;
		this.to = to;
		this.fromNum = fromNum;
		this.toNum = toNum;
	}

	public int getFrom() {
		return fromNum;
	}
	
	public int getTo() {
		return toNum;
	}
	
	@Override
	public String toString() {
		//return "EDGE: " + " From " + from.getSubNum() + " to " + to.getSubNum();
		return "EDGE: from " + fromNum + " to " + toNum;
	}
	
}
