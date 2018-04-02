package colorchooser;

import javax.swing.JFrame;

/**
 * A basic color chooser GUI.
 * 
 * @author CS121 Instructors
 */
public class ColorChooser
{
	/**
	 * Initialize the GUI and make it visible.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Mini-ColorChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new ColorChooserPanel());
		
		frame.pack();
		frame.setVisible(true);
	}
}
