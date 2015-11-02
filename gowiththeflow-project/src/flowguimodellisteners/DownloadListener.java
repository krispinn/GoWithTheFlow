package flowguimodellisteners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import flowdata.GenerateInfo;
import flowguicontroller.FlowController;
import flowguimodel.GraphModel;
import flowguimodel.InteractiveModel;
import flowguiview.FlowView;
import flowguiview.InteractiveView;

public class DownloadListener extends FlowController implements MouseListener{
	
	public DownloadListener(GraphModel graphModel, FlowView graphView,
			InteractiveModel interactiveModel, InteractiveView interactiveView) {
		super(graphModel, graphView, interactiveModel, interactiveView);
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
			System.out.println("Successfully downloaded data!");
		} catch (Exception e1) {
			System.err.println("Unable to download data!");
			e1.printStackTrace();
		}
		
	}

}