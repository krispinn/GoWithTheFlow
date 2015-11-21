package flowguiview;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class DisclaimerView extends JPanel {

	/**
	 * Field for string that holds the disclaimer text(with HTML tags)
	 */
	private String purpose = "<html><p>This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.<br>"
			+ "GoWithTheFlow was developed by: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas.<br>"
			+ "The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.</p></html>";

	/**
	 * Makes a new border in the panel and creates a label with the text from
	 * the 'purpose' field
	 */
	public DisclaimerView() {

		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Disclaimer"),
				BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		JLabel jLabel = new JLabel("<html><div style=\"text-align: center;\">" + purpose + "</html>");
		this.add(jLabel);

	}

}
