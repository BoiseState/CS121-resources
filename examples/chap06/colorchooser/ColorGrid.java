package colorchooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Represents a 2-dimensional grid of ColorGridOptions. Uses a GridLayout to arrange the
 * colors in a grid. This class extends JPanel, which means it is a JPanel. We are extending
 * the functionality of a JPanel by adding our own methods to it.
 * 
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class ColorGrid extends JPanel
{
	private final Color[][] COLORS = { 
			{ Color.RED,    Color.GREEN,  Color.BLUE }, 
			{ Color.YELLOW, Color.CYAN,   Color.MAGENTA },
			{ Color.WHITE,  Color.BLACK,  Color.GRAY },
			{ Color.PINK,   Color.ORANGE, Color.LIGHT_GRAY}
	};
	
	private ColorGridOption[][] colorOptions;
	
	/**
	 * Creates a new ColorGrid panel. Sets the layout, preferred size, and adds the
	 * ColorGridOption buttons to the grid.
	 * 
	 * @param displayPanel The panel to update when ColorGridOption is clicked.
	 */
	public ColorGrid(JPanel displayPanel) 
	{
		// Sets the layout and preferred size of this ColorGrid panel to the dimensions of our color array.
		this.setLayout(new GridLayout(COLORS.length, COLORS[0].length, 1, 1));
		this.setPreferredSize(new Dimension(300, 300));
		
		// Instantiates color options array to the dimensions of our color array.
		colorOptions = new ColorGridOption[COLORS.length][COLORS[0].length];
		for (int i = 0; i < colorOptions.length; i++)
		{
			for(int j = 0; j < colorOptions[0].length; j++)
			{
				// Create option for color at index [i][j]. The option needs to know that it should update
				// the displayPanel when clicked, so we are passing a reference to displayPanel to the constructor.
				colorOptions[i][j] = new ColorGridOption(COLORS[i][j], displayPanel);
				
				// Add the option's button to this GridOption panel.
				this.add(colorOptions[i][j].getButton());
			}
		}
	}
}
