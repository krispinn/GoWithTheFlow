package flowguiview;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;

import flowguimodel.InteractiveModel;
import flowguimodel.MxGraphComponentModel;

public class FlowView extends JFrame {
	
	private InteractiveModel model;
	
	private InteractiveView view;

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private GraphView graphView;
	
	private JPanel cards;

	
	public FlowView(InteractiveView interactiveView, InteractiveModel model, MxGraphComponentModel graphComponent) throws Exception {
	
		super("GoWithTheFlow");

		
		this.model = model;
		this.view = interactiveView;
		
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
