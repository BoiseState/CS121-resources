package colorchooser;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Represents a 2-dimensional grid of ColorGridOptions. Uses a GridLayout to arrange the
 * colors in a grid.
 * 
 * @author CS121 Instructors
 */
public class ColorGrid
{
	private ColorGridOption[][] colorOptions;
	private JPanel gridPanel;
	
	private final Color[][] COLORS = { 
			{ Color.RED,    Color.GREEN,  Color.BLUE }, 
			{ Color.YELLOW, Color.CYAN,   Color.MAGENTA },
			{ Color.WHITE,  Color.BLACK,  Color.GRAY },
			{ Color.PINK,   Color.ORANGE, Color.LIGHT_GRAY}
	};
	
	/**
	 * Creates a new ColorGrid panel. Sets the layout, preferred size, and adds the
	 * ColorGridOption buttons to the grid.
	 * 
	 * @param displayPanel The panel to update when ColorGridOption is clicked.
	 */
	public ColorGrid(JPanel displayPanel) 
	{
		// Creates a JPanel with GridLayout with dimensions of the COLORS array.
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(COLORS.length, COLORS[0].length, 1, 1));
		gridPanel.setPreferredSize(new Dimension(300, 300));
		
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
				gridPanel.add(colorOptions[i][j].getButton());
			}
		}
	}
	
	/**
	 * Returns a reference to the JPanel representing this ColorGrid.
	 * @return a reference to the JPanel.
	 */
	public JPanel getJPanel()
	{
		return gridPanel;
	}
}
