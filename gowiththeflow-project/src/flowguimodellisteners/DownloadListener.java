package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import flowdata.GenerateInfo;
import flowguiview.InteractiveView;

/**
 * This class handles all mouse events for the Download button.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 *
 */
public class DownloadListener implements MouseListener {

	/**
	 * The constructor for the Download Listener calls the registerDownloadButton method
	 * 
	 * @param interactiveView
	 */
	public DownloadListener(InteractiveView interactiveView) {
		interactiveView.registerDownloadButton(this);
	}

	/**
	 * Doesn't do anything on mouse click
	 */
	public void mouseClicked(MouseEvent arg0) {
		// do nothing
	}

	/**
	 * Doesn't do anything if the mouse enters the window
	 */
	public void mouseEntered(MouseEvent arg0) {
		// do nothing
	}

	/**
	 * Doesn't do anything if the mouse exits the window
	 */
	public void mouseExited(MouseEvent arg0) {
		// do nothing
	}

	/**
	 * Doesn't do anything on mouse press
	 */
	public void mousePressed(MouseEvent arg0) {
		// do nothing
	}

	/**
	 * If the mouse is released on the button it generates course information, updating the current
	 * set of course data.
	 */
	public void mouseReleased(MouseEvent arg0) {
		try {
			new GenerateInfo();
			System.out.println("Successfully downloaded data!(1)");
		} catch (Exception e1) {
			System.err.println("Unable to download data!");
			e1.printStackTrace();
		}
	}

}
