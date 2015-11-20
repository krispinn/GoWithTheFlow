package flowguiview;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Simple JPanel class for the "welcome" Page
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardena
 *
 */
public class WelcomeView extends JPanel {

	/**
	 * constructor that creates the JLabel labeled "Welcome!"
	 */
	public WelcomeView() {
		JLabel a = new JLabel("Welcome!");
		this.add(a);
	}

}
