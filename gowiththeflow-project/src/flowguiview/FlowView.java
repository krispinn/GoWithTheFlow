package flowguiview;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mxgraph.swing.mxGraphComponent;

import flowguimodel.MxGraphComponentModel;
import flowguimodellisteners.VertexListener;

public class FlowView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2707712944901661771L;
	
	private mxGraphComponent graphComponent;
	
	private FlowView instance;
	
	private InteractiveView interactiveView;
	
	private String purpose = "DISCLAIMER: This program is for informational purposes only. "
			+ "Please refer to your academic advisor for degree and course planning.\n"
			+ "GoWithTheFlow was developed by: Bilal Saddiqui, Danny Tsang, Jason Blig, Miguel Cardenas, and Mostafa Dabas "
			+ "at The University of Texas at San Antonio. CS 3443 Applications Programming, Fall 2015, Professor Tom Bylander.";
		
	public FlowView(InteractiveView interactiveView, MxGraphComponentModel graphComponent) throws Exception {
		
		super("GoWithTheFlow");
		this.interactiveView = interactiveView;
		
		JPanel info = new JPanel();
		JTextArea infoArea = new JTextArea();
		infoArea.setText(purpose);
		infoArea.setWrapStyleWord(true);
		info.add(infoArea);
		this.graphComponent = graphComponent;
		this.add(graphComponent);
		this.add(interactiveView, BorderLayout.EAST);
		this.add(info, BorderLayout.SOUTH);
		
		this.pack();	
		this.setSize(1366, 768);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void setGraphComponent(final MxGraphComponentModel graphComponent) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					instance = new FlowView(interactiveView, graphComponent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	public void registerVertexMouseListener(VertexListener listener) {
		graphComponent.getGraphControl().addMouseListener(listener);
	}
	
}
