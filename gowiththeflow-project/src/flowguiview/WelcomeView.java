package flowguiview;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomeView extends JPanel{
	
	
	private String info = "<html><p>Welcome to gowiththeflow.<br>"
							+ "The program has two navigational menus, one to select your college and the second to specify the major.<br>"
							+ "There is a hover feature implemented to allow for easy information access<br>"
							+ "Lastly, a textbox is included as well to display the selected courses' info for a more traditional view.</p></html>";
	
	private String purpose = "<html><p>This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.<br>"
			+ "GoWithTheFlow was developed by: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas.<br>"
			+ "The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.</p></html>";
	
	
	public WelcomeView(){
		this.setLayout(new BorderLayout());
		
		JLabel tutorialInfo = new JLabel("<html><div style=\"text-align: center;\">" + info + "</html>");
		tutorialInfo.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(tutorialInfo, BorderLayout.CENTER);
		
		
		JLabel disclaimer = new JLabel("<html><div style=\"text-align: center;\">" + purpose + "</html>");
		disclaimer.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(disclaimer, BorderLayout.SOUTH);	
	}
	
}
