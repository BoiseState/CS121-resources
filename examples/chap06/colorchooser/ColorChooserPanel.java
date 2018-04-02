package colorchooser;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * A basic color chooser GUI. This class extends JPanel, which means it is a JPanel.
 * We are extending the functionality of a JPanel by adding our own methods to it.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorChooserPanel extends JPanel
{
	private ColorGridPanel colorGridPanel;
	private JPanel displayPanel;
	
	/**
	 * Creates a new ColorChooser GUI.
	 */
	public ColorChooserPanel()
	{
		// Sub-panel to display chosen color.
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(300,300));
		
		// Sub-panel with grid of colors to choose from. The color grid needs to know which
		// ActionListener (ColorOptionButtonListener) to use when its buttons are clicked.
		colorGridPanel = new ColorGridPanel(new ColorOptionButtonListener());
		
		// Add sub-panels to this ColorChooserPanel.
		this.add(colorGridPanel);
		this.add(displayPanel);
	}
	
	
	/**
	 * The ActionListener for a ColorOptionButton. When the button is clicked,
	 * it will set the background color of the display panel and add to the number
	 * of clicks for the button.
	 */
	private class ColorOptionButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// Get the source of the event (we know it will be from a ColorOptionButton, so we
			// cast the result to a ColorOptionButton)
			ColorOptionButton clicked = (ColorOptionButton) e.getSource();
			
			// Set display panel to the color of the button that was clicked
			displayPanel.setBackground(clicked.getColor());
			
			// Tell the button to increase its clicked count.
			clicked.addClick();
		}
	}
}
