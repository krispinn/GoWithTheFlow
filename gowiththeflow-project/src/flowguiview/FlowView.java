package flowguiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


import javax.swing.JPanel;
import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;

/**
 * 
 * @author Mostafa Dabas, Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel
 *         Cardenas
 */
public class FlowView extends JFrame {

	/**
	 * 
	 */
	private InteractiveModel model;

	/**
	 * 
	 */
	private InteractiveView view;
	
	private JMenuBar menuBar;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	/**
	 * 
	 */
	private GraphView graphView;

	/**
	 * 
	 */
	private JPanel cards;

	/**
	 * When FlowView is first initialized, a welcome screen is in place of the
	 * graph (no major selected), The interactive view is added on the left side
	 * of the panel, disclaimer is added to the bottom. 
	 */
	public FlowView(InteractiveView interactiveView, InteractiveModel model, MxGraphComponentModel graphComponent,
			WelcomeView welcomeView) throws Exception {

		super("GoWithTheFlow");
		ImageIcon img = new ImageIcon("cool.png");
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

	/**
	 * When this method is called the welcome screen is replaced by the graph of
	 * the major that was selected
	 */
	public void setGraph(GraphView graphView) {
		cards.removeAll();
		cards.add(graphView);
		cards.validate();
		cards.setVisible(true);
	}

}
