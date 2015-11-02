package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import flowdata.GenerateInfo;
import flowguimodel.InteractiveModel;
import flowguiview.InteractiveView;

public class DownloadListener extends ListenerModel implements MouseListener{

	public DownloadListener(InteractiveView interactiveView,
			InteractiveModel interactiveModel) {
		super(interactiveView, interactiveModel);
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
			JOptionPane.showMessageDialog(null, "Successfully downloaded data!");
			System.out.println("Successfully downloaded data!");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Unable to download data!");
			System.err.println("Unable to download data!");
			e1.printStackTrace();
		}
		
	}

}
