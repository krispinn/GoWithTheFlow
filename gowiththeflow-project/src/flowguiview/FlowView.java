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
 * The window where everything is displayed.
 * 
 * @author Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, Mostafa Dabas
 */
public class FlowView extends JFrame {

	/**
	 * The model for the side panel.
	 */
	private InteractiveModel model;

	/**
	 * Displays the information in the InteractiveModel.
	 */
	private InteractiveView view;

	/**
	 * A menu bar at the top.
	 */
	private JMenuBar menuBar;

	/**
	 * Not used.
	 */
	private static final long serialVersionUID = -2707712944901661771L;

	/**
	 * The graph to be displayed.
	 */
	private GraphView graphView;

	/**
	 * Determines which graph to display.
	 */
	private JPanel cards;

	/**
	 * When FlowView is first initialized, a welcome screen is in place of the graph (no major
	 * selected), The interactive view is added on the left side of the panel, disclaimer is added
	 * to the bottom.
	 */
	public FlowView(InteractiveView interactiveView, InteractiveModel model,
			MxGraphComponentModel graphComponent, WelcomeView welcomeView) throws Exception {
		super("GoWithTheFlow");

		ImageIcon img = new ImageIcon("logo.png");
		this.setIconImage(img.getImage());

		menuBar = new JMenuBar();

		this.model = model;
		this.view = interactiveView;

		this.add(interactiveView, BorderLayout.EAST);
		graphView = new GraphView(graphComponent);
		cards = new JPanel(new CardLayout());
		cards.add(welcomeView);
		this.add(cards);

		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Replaces welcome screen with graph of selected major.
	 */
	public void setGraph(GraphView graphView) {
		cards.removeAll();
		cards.add(graphView);
		cards.validate();
		cards.setVisible(true);
	}

}
