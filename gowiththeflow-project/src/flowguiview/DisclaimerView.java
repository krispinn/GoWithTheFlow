package flowguiview;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisclaimerView extends JPanel{

	private String purpose = "<html><p>This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.<br>"
			+ "GoWithTheFlow was developed by: Bilal Saddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas.<br>"
			+ "The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.</p></html>";
	
	public DisclaimerView() {
		
		this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Disclaimer"),
				BorderFactory.createEmptyBorder(0, 0, 0, 0)));
		JLabel jLabel = new JLabel(purpose);
		this.add(jLabel);
		
	}
	
}
