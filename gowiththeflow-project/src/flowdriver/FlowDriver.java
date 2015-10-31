package flowdriver;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import flowmodel.ListOfColleges;
import flowmodel.ListOfMajors;
import flowview.GraphView;
import flowview.InteractiveView;

/**
 * Executes the main method and finds departments/majors from given UTSA URL
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa
 *         Dabas
 * 
 */
public class FlowDriver {
	
/**
 * 
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {

		//new GenerateInfo();

		GraphView graphView = new GraphView();
		
		InteractiveView interactiveView = new InteractiveView();
		
		graphView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// need to modify automatically for other display option.
		
		graphView.getContentPane().add(interactiveView, BorderLayout.EAST);
		
		graphView.setSize(1366, 768);
		
		graphView.setVisible(true);
		
		ListOfColleges a = new ListOfColleges();
		a.getDepartments();
		ListOfMajors lom = new ListOfMajors();
		lom.populate();
		
	}
}		

