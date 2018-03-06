/**
 * Demonstrates the use of a programmer-defined class.
 * 
 * @author Java Foundations
 */
public class SnakeEyes
{
	/**
	 * Creates two Die objects and rolls them several times, counting the number
	 * of snake eyes that occur.
	 * 
	 * @param args
	 *            (unused)
	 */
	public static void main(String[] args)
	{
		final int ROLLS = 500;
		int num1, num2, count = 0;

		Die die1 = new Die();
		Die die2 = new Die();

		for (int roll = 1; roll <= ROLLS; roll++)
		{
			System.out.println("roll " + roll);
			
			// roll the dice
			die1.roll();
			die2.roll();

			// get the face values
			num1 = die1.getFaceValue();
			num2 = die2.getFaceValue();

			// print the values
			System.out.println("die1 value: " + num1);
			System.out.println("die2 value: " + num2);

			System.out.println();

			if (num1 == 1 && num2 == 1) // check for snake eyes
			{
				count++;
			}
		}

		System.out.println("Number of rolls: " + ROLLS);
		System.out.println("Number of snake eyes: " + count);
		System.out.println("Ratio: " + (double) count / ROLLS);
	}
}
