package flowguiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import flowguimodel.MxGraphComponentModel;

public class FlowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private String purpose = "DISCLAIMER: This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.\n"
			+ "GoWithTheFlow was developed by: Bilal Saddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas "
			+ "at The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.";

	private GraphView graphView;
	
	private JPanel cards;
	
	public FlowView(InteractiveView interactiveView, MxGraphComponentModel graphComponent) throws Exception {
	
		super("GoWithTheFlow");
		
		this.add(interactiveView, BorderLayout.EAST);
		
		JPanel info = new JPanel();
		JTextArea infoArea = new JTextArea();
		infoArea.setText(purpose);
		infoArea.setWrapStyleWord(true);
		info.add(infoArea);
		this.add(info, BorderLayout.SOUTH);

		graphView = new GraphView(graphComponent);
		cards = new JPanel(new CardLayout());
		cards.add(graphView);
		this.add(cards);
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void setGraph(GraphView graphView) {
		cards.removeAll();
		cards.add(graphView);
		cards.validate();
		cards.setVisible(true);
	}
	
}
