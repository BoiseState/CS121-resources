import java.util.Scanner;

/**
 * Demonstrates how to use delimiters with Scanner
 */
public class UseScannerDelimiter {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String text = "Twinkle, twinkle, little star,\n" +
			"How I wonder what you are!\n" +
			"Up above the world so high,\n" +
			"Like a diamond in the sky!";

		System.out.println("---------- Scanner with default delimiter ----------");
		scanDefault(text);
		System.out.println("---------- Scanner with delimiter string ----------");
		scanWithDelims( text, "[ \t\r\f\n!,.]+");
		System.out.println("------------------------------\n");
	}

	/**
	 * Breaks the given text into words using the default Scanner delimiters.
	 * The default delimiter set is " \t\n\r\f": the space character, the tab character,
	 * the newline character, the carriage-return character, and the form-feed character.
	 * Delimiter characters themselves will not be treated as words.
	 * @param the string to break up.
	 */
	public static void scanDefault(String text)
	{
		Scanner scan = new Scanner(text);

		int count = 0;

		String word;
		while (scan.hasNext()) {
			word = scan.next();
			System.out.println("\t" + word);
			count ++;
		}

		System.out.println( "The string has " + count + " words");
	}

	/**
	 * Breaks the given text into words using the given delimiters.
	 * Delimiter characters themselves will not be treated as words.
	 * @param the string to scan.
	 */
	public static void scanWithDelims(String text, String delimiters)
	{
		Scanner scan = new Scanner(text);
		scan.useDelimiter(delimiters);

		int count = 0;

		String word;
		while (scan.hasNext()) {
			word = scan.next();
			System.out.println("\t" + word);
			count++;
		}

		System.out.println( "The string has " + count + " words");
	}

}
