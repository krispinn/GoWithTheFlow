package CourseData;

import javax.swing.JFrame;

import testdannybilal.GenerateGraph;

/**
 * Executes the main method and finds departments/majors from given UTSA URL
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa
 *         Dabas
 * 
 */
public class Driver {
	
/**
 * 
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {

		//new GenerateInfo();
		
		GenerateGraph frame = new GenerateGraph();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// need to modify automatically for other display option.
		frame.setSize(1366, 768);
		frame.setVisible(true);
		
		
	}
}		

