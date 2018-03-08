/**
 * Demonstrates the creation and use of a user-defined class.
 * @author Lewis/Loftus/amit
 */

public class RollingDice
{
   	/**
     Creates two Die objects and rolls them several times.
   	*/
   	public static void main (String[] args)
   	{
      	int sum;

      	Die die1 = new Die();
      	Die die2 = new Die();
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

      	die1.roll(); die2.roll();
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

      	die1.roll(); die2.roll();
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

      	die1.roll(); die2.roll();
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

      	die1.roll();
      	die2.setFaceValue(4);
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);

      	sum = die1.getFaceValue() + die2.getFaceValue();
      	System.out.println ("Sum: " + sum);

      	die1.roll(); die2.roll();
      	System.out.println ("Die One: " + die1 + ", Die Two: " + die2);
      	
      	sum = die1.getFaceValue() + die2.getFaceValue();
      	System.out.println ("New sum: " + sum);
   	}
}
