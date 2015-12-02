package flowguiview;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Simple JPanel class for the "welcome" Page.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 */
public class WelcomeView extends JPanel {

	/**
	 * Field for the string (HTML Tags) that will have all the steps needed to run the program.
	 */
	private String info = "<html><p>Welcome!<br><br>" + "Quick Tutorial:<br><br>"
			+ "1) Update Course Information - downloads data from UTSA undergraduate catalog<br><br>"
			+ "2) Select your College - ex: sciences<br><br>"
			+ "3) Select your Major - ex: computerscience<br><br>"
			+ "4) Update Selected Major - displays your selected major in a graph<br><br>"
			+ "5) Hide Labs/Recitations - redraws your graph with(out) labs and/or recitations<br><br>"
			+ "6) Course Information - updates when you select a course(vertex) on the graph<br><br>"
			+ "7) Tooltips - shows up when the mouse is held over a course(vertex) on the graph</p></html>";

	/**
	 * Field for the string (HTML Tags) that explains the purpose of the application.
	 */
	private String purpose = "<html><p>This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.<br>"
			+ "GoWithTheFlow was developed by: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas.<br>"
			+ "The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.</p></html>";

	/**
	 * Constructor that sets up layout, creates two JLabels(for each string), then adds them to the
	 * view
	 */
	public WelcomeView() {
		this.setLayout(new BorderLayout());

		JLabel tutorialInfo = new JLabel(
				"<html><div style=\"text-align: center;\">" + info + "</html>");
		tutorialInfo.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(tutorialInfo, BorderLayout.CENTER);

		JLabel disclaimer = new JLabel(
				"<html><div style=\"text-align: center;\">" + purpose + "</html>");
		disclaimer.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(disclaimer, BorderLayout.SOUTH);
	}

}
