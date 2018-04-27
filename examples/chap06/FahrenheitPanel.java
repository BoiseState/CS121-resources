import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Demonstrates the use of BorderLayout, sub-panels, and text fields.
 * @author Java Foundations
 * @author CS121 Instructors
 */
@SuppressWarnings("serial")
public class FahrenheitPanel extends JPanel
{
	private JLabel inputLabel, outputLabel, resultLabel;
	private JTextField inputField;
	private JButton calculateButton;

	/**
	 * Constructor: Sets up the main GUI components.
	 */
	public FahrenheitPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		// Add the same action listener to text field (for when we hit enter key)
		// and the enter button. They should have same effect.
		TempListener listener = new TempListener();
		
		// Create input sub-panel
		JPanel inputPanel = new JPanel();
		//inputPanel.setBackground(Color.CYAN);
		inputLabel = new JLabel("Temperature in Fahrenheit:");
		inputField = new JTextField(5);
		inputField.addActionListener(listener);
		inputPanel.add(inputLabel);
		inputPanel.add(inputField);
		
		// Create convert sub-panel
		JPanel buttonPanel = new JPanel();
		//buttonPanel.setBackground(Color.MAGENTA);
		calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(listener);
		buttonPanel.add(calculateButton);
		
		// Create output sub-panel
		JPanel outputPanel = new JPanel();
		//outputPanel.setBackground(Color.YELLOW);
		outputLabel = new JLabel("Temperature in Celsius: ");
		resultLabel = new JLabel("-");
		outputPanel.add(outputLabel);
		outputPanel.add(resultLabel);
		
		// Add all sub-panels to the this panel.
		add(inputPanel);
		add(buttonPanel);
		add(outputPanel);
	}

	/**
	 * Represents an action listener for the temperature input field.
	 */
	private class TempListener implements ActionListener
	{
		/**
		 * Performs the conversion when the enter key is pressed in
		 * the text field.
		 */
		public void actionPerformed(ActionEvent event)
		{
			// Get the text from the text field
			String text = inputField.getText();

			try
			{
				double fahrenheitTemp = Double.parseDouble(text);
				double celsiusTemp = (fahrenheitTemp - 32) * 5.0 / 9;
				String result = String.format("%6.2f", celsiusTemp);
	
				resultLabel.setText(result);
			}
			catch (NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "That was not a valid number",
						"Invalid input", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
