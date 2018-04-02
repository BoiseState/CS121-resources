package colorchooser;

import java.awt.Color;

import javax.swing.JButton;

/**
 * Represents a color option button in the ColorChooserPanels's ColorGridPanel. 
 * 
 * This class extends JButton, which means it is a JButton.
 * We are extending the functionality of a JButton by adding our own methods to it.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorOptionButton extends JButton
{
	private Color color;
	private int clicks;
	
	/**
	 * Creates a ColorGridOption with the specified background color.
	 * 
	 * @param color The color of this option.
	 */
	public ColorOptionButton(Color color)
	{
		this.color = color;
		this.clicks = 0;
		
		this.setBackground(color);
		this.setOpaque(true); // MacOSX fix for background color.
		this.setBorderPainted(false); // MacOSX fix for background color.
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
	 * Returns the number of times this option was selected.
	 * @return the number of clicks.
	 */
	public int getClicks()
	{
		return clicks;
	}
	
	/**
	 * Increases the number of clicks by one and updates the text on the button
	 * with the number of clicks.
	 */
	public void addClick()
	{
		clicks++;
		this.setText(Integer.toString(clicks));
	}
}
