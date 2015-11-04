package flowguimodel;

/**
 * In the class below, we take to 'CourseModels' provided in the constructor and 
 * use their relative indexes stored in the 'main CourseModel arraylist' to create links between them
 * 
 * @author zli781
 *
 */




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
