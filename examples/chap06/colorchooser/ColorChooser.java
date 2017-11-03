package colorchooser;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * A basic color chooser GUI. This class extends JPanel, which means it is a JPanel.
 * We are extending the functionality of a JPanel by adding our own methods to it.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorChooser extends JPanel
{
	private ColorGrid colorGrid;
	
	/**
	 * Creates a new ColorChooser GUI.
	 */
	public ColorChooser()
	{
		// Sub-panel to display chosen color.
		JPanel displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		
		// Sub-panel with grid of colors to choose from. The color grid needs to know which
		// panel (displayPanel) to display the color on.
		colorGrid = new ColorGrid(displayPanel);
		
		// Add sub-panels to this ColorChooser panel.
		this.add(colorGrid.getJPanel());
		this.add(displayPanel);
	}
	
	/**
	 * Initialize the GUI and make it visible.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Mini-ColorChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ColorChooser());
		
		frame.pack();
		frame.setVisible(true);
	}
}
