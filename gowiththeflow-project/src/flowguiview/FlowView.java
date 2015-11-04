package flowguiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import flowguimodel.MxGraphComponentModel;

public class FlowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private GraphView graphView;
	
	private JPanel cards;
	
	public FlowView(InteractiveView interactiveView, MxGraphComponentModel graphComponent) throws Exception {
	
		super("GoWithTheFlow");
		
		this.add(interactiveView, BorderLayout.EAST);
		this.add(new DisclaimerView(), BorderLayout.SOUTH);

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
