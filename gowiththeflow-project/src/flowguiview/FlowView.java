package flowguiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;

public class FlowView extends JFrame {
	
	private InteractiveModel model;
	
	private InteractiveView view;
	
	private JMenuBar menuBar;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private GraphView graphView;
	
	private JPanel cards;

	
	public FlowView(InteractiveView interactiveView, InteractiveModel model, MxGraphComponentModel graphComponent, WelcomeView welcomeView) throws Exception {
	
		super("GoWithTheFlow");
		ImageIcon img = new ImageIcon("logo.jpg");
		this.setIconImage(img.getImage());
		
		menuBar = new JMenuBar();
		
		//this.setJMenuBar(menuBar);
		
		this.model = model;
		this.view = interactiveView;
		
		this.add(interactiveView, BorderLayout.EAST);
		//this.add(new DisclaimerView(), BorderLayout.SOUTH);
		graphView = new GraphView(graphComponent);
		cards = new JPanel(new CardLayout());
		cards.add(welcomeView);
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
