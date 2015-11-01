package flowguimodel;

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

	public int getFromNum() {
		return fromNum;
	}
	
	public int getToNum() {
		return toNum;
	}
	
	public CourseModel getFrom() {
		return from;
	}
	
	public CourseModel getTo() {
		return to;
	}
	
	@Override
	public String toString() {
		return "EDGE: [" + fromNum + "]"+ from.getSubjectNumber() + " to [" + toNum + "]" + to.getSubjectNumber();
	}
	
}
