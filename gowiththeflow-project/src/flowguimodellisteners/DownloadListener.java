package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import flowdata.GenerateInfo;
import flowguiview.InteractiveView;

public class DownloadListener implements MouseListener{
	
	public DownloadListener(InteractiveView interactiveView) {
		interactiveView.registerDownloadButton(this);
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

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
