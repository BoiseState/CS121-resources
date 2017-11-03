package colorchooser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents a color option button in the ColorChooser's ColorGrid. The option contains a JButton
 * and an ActionListener for the button. When the button is clicked, it will update the specified
 * displayPanel with the color.
 * 
 * @author CS121 Instructors
 */
public class ColorGridOption
{
	private Color color;
	private JButton button;
	private JPanel displayPanel;
	
	/**
	 * Creates a ColorGridOption with the specified background color.
	 * 
	 * @param color The color of this option.
	 * @param displayPanel The panel to update when the option is clicked.
	 */
	public ColorGridOption(Color color, JPanel displayPanel)
	{
		this.displayPanel = displayPanel;
		this.color = color;
		
		button = new JButton();
		button.setBackground(color);
		button.setOpaque(true); // MacOSX fix for background color.
		button.setBorderPainted(false); // MacOSX fix for background color.
		button.addActionListener(new ColorOptionListener());
	}
	
	/**
	 * Returns the color of this option.
	 * @return the color.
	 */
	public Color getColor()
	{
		return color;
	}
	
	/**
	 * Returns a reference to the button corresponding to this color option.
	 * @return a reference to the button.
	 */
	public JButton getButton()
	{
		return button;
	}
	
	/**
	 * The ActionListener for the button in this color grid option. When the button is clicked,
	 * it will set the background color of the display panel.
	 */
	private class ColorOptionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// set display panel to the color of the button that was clicked
			displayPanel.setBackground(color);
		}
	}
}
