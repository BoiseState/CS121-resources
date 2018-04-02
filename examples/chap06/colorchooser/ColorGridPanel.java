package colorchooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

/**
 * Represents a 2-dimensional grid of ColorOptionButtons. Uses a GridLayout to arrange the
 * colors in a grid.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorGridPanel extends JPanel
{
	private ColorOptionButton[][] colorOptions;
	
	private final Color[][] COLORS = { 
			{ Color.RED,    Color.GREEN,  Color.BLUE }, 
			{ Color.YELLOW, Color.CYAN,   Color.MAGENTA },
			{ Color.WHITE,  Color.BLACK,  Color.GRAY },
			{ Color.PINK,   Color.ORANGE, Color.LIGHT_GRAY}
	};
	
	/**
	 * Creates a new ColorGridPanel. Sets the layout, preferred size, and adds the
	 * ColorOptionButtons to the grid.
	 */
	public ColorGridPanel(ActionListener listener) 
	{
		// Creates a JPanel with GridLayout with dimensions of the COLORS array.
		this.setLayout(new GridLayout(COLORS.length, COLORS[0].length, 1, 1));
		this.setPreferredSize(new Dimension(300, 300));
		
		// Instantiates color options array to the dimensions of our color array.
		colorOptions = new ColorOptionButton[COLORS.length][COLORS[0].length];
		for (int i = 0; i < colorOptions.length; i++)
		{
			for(int j = 0; j < colorOptions[0].length; j++)
			{
				// Create option button for color at index [i][j].
				colorOptions[i][j] = new ColorOptionButton(COLORS[i][j]);
				
				// Add the ActionListener to the button at index [i][j]
				colorOptions[i][j].addActionListener(listener);
				
				// Add the option button to this GridOptionPanel.
				this.add(colorOptions[i][j]);
			}
		}
	}
}
