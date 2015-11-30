package flowguimodel;

/**
 * In the class below, we take to 'CourseModels' provided in the constructor and use their relative
 * indexes stored in the 'main CourseModel arraylist' to create links between them
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 *
 */
public class DirectedEdgeModel {

	/**
	 * The CourseModel that the edge is coming from
	 */
	private CourseModel from;

	/**
	 * The CourseModel that the edge is connecting to
	 */
	private CourseModel to;

	/**
	 * The Subject Number of the 'from' variable
	 */
	private int fromNum;

	/**
	 * The Subject Number of the 'to' variable
	 */
	private int toNum;

	/**
	 * Assigns values based on the parameters to the DirectedEdgeModel's fields (constructor)
	 * 
	 * @param from
	 *            where the edge will be coming from
	 * @param to
	 *            where the edge will be going to
	 * @param fromNum
	 *            the subject number of the 'from' CourseModel
	 * @param toNum
	 *            the subject number of the 'to' CourseModel
	 */
	public DirectedEdgeModel(CourseModel from, CourseModel to, int fromNum, int toNum) {
		this.from = from;
		this.to = to;
		this.fromNum = fromNum;
		this.toNum = toNum;
	}

	/**
	 * Returns the Subject Number of the 'from' variable
	 * 
	 * @return an integer that represents a Subject Number
	 */
	public int getFromNum() {
		return fromNum;
	}

	/**
	 * Returns the Subject Number of the 'to' variable
	 * 
	 * @return an integer that represents a Subject Number
	 */
	public int getToNum() {
		return toNum;
	}

	/**
	 * Returns the 'from' variable
	 * 
	 * @return a CourseModel that is where the edge is coming from
	 */
	public CourseModel getFrom() {
		return from;
	}

	/**
	 * Returns the 'to' variable.
	 * 
	 * @return a CourseModel that is where the edge is connecting to
	 */
	public CourseModel getTo() {
		return to;
	}

	/**
	 * Returns a description of the edge giving the 'to' and 'from' subject numbers
	 */
	@Override
	public String toString() {
		return "EDGE: [" + fromNum + "]" + from.getSubjectNumber() + " to [" + toNum + "]"
				+ to.getSubjectNumber();
	}

}
