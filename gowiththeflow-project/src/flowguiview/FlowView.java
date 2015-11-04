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

public class FlowView extends JFrame implements ActionListener {
	
	

	
	private InteractiveModel model;
	
	private InteractiveView view;
	
	/**
	 * The below are required to set up the menu bar
	 */
	
	private JMenuBar menuBar;
	private JMenu menu1, menu2;
	private JMenuItem menuItem;
	private JRadioButtonMenuItem rbMenuItem;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private String purpose = "DISCLAIMER: This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.\n"
			+ "GoWithTheFlow was developed by: Bilal Siddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas "
			+ "at The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.";

	
	private GraphView graphView;
	
	private JPanel cards;
	
/*	public void addModel(InteractiveModel model){
		this.model = model;
	}*/
	
	public FlowView(InteractiveView interactiveView, InteractiveModel model, MxGraphComponentModel graphComponent) throws Exception {
	
		super("GoWithTheFlow");

		
		this.model = model;
		this.view = interactiveView;
		
		/**
		 * The menu stuff goes below here
		 */
		
		//Create the menu bar.
		menuBar = new JMenuBar();

		//Build the first menu.
		menu1 = new JMenu("Select College");
		menu1.setMnemonic(KeyEvent.VK_A);
		menu1.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
		menuBar.add(menu1);
		
		menu1.addSeparator();
		
		ButtonGroup group = new ButtonGroup();
		for(String college : model.getColleges()){
			rbMenuItem = new JRadioButtonMenuItem(college);
			rbMenuItem.setSelected(true);
			rbMenuItem.addActionListener(this);
			rbMenuItem.setMnemonic(KeyEvent.VK_R);			
			group.add(rbMenuItem);
			menu1.add(rbMenuItem);
		}
		
		this.setJMenuBar(menuBar);
		
		//Build the second menu.
				menu2 = new JMenu("Select Major");
				menu2.setMnemonic(KeyEvent.VK_A);
				menu2.getAccessibleContext().setAccessibleDescription("The only menu in this program that has menu items");
				menuBar.add(menu2);
				
				menu2.addSeparator();
				
				group = new ButtonGroup();
				for(int i = 0; i < model.getMajorList().size(); i++){
					rbMenuItem = new JRadioButtonMenuItem(model.getMajorList().elementAt(i));
					rbMenuItem.setSelected(true);
					rbMenuItem.addActionListener(this);
					rbMenuItem.setMnemonic(KeyEvent.VK_R);			
					group.add(rbMenuItem);
					menu2.add(rbMenuItem);
				}
				
				this.setJMenuBar(menuBar);
		
		
		
		
		
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
	
	
	public void actionPerformed(ActionEvent command) {
	
		String selected = command.getActionCommand();
		
		//if(((JMenu)command.getSource()).isSelected())
		//if(command.getSource().equals(menuBar1))
			model.setMajors(selected);
		//else
		//String selected = interactiveView.getSelectedMajor();
		//	model.setSelectedMajor(selected);
		
			view.updateMajors(selected);
		//System.out.println(selected);
			
	
	}
}
