package CourseData;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import flowmodel.FlowModel;
import flowview.FlowView;
import test.GenerateGraph;

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
		FlowModel model = new FlowModel();
		FlowView view = new FlowView(model);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// need to modify automatically for other display option.
		frame.getContentPane().add(view, BorderLayout.EAST);
		frame.setSize(1366, 768);
		
		frame.setVisible(true);
		
		
	}
}		

