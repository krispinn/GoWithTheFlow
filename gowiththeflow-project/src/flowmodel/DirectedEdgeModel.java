package flowmodel;

public class DirectedEdgeModel {

	private CourseModel from;
	private CourseModel to;
	private int fromNum;
	private int toNum;
	
	public DirectedEdgeModel(CourseModel from, CourseModel to, int fromNum, int toNum) {
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
