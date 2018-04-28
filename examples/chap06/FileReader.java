import javax.swing.JFrame;

/**
 * Demonstrates the use of a scroll pane, text area, and file chooser.
 * @author CS121 Instructors
 */
public class FileReader
{
	/**
	 * Creates and launches the JFrame.
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("File Reader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new FileReaderPanel());
		frame.pack();
		frame.setVisible(true);
	}
}
