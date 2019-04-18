
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Illustrates how to grow an array on the fly. Show the time taken when we grow
 * the array by 1 each time.
 *
 * time java GrowingArray wordlist.txt 1
 *
 * Then see the improvement if we double the capacity each time we grow the array. The
 * command line argument of 0 doubles the size each time.
 *
 * time java GrowingArray wordlist.txt 0
 * 
 * @author amit
 * @author marissa (slight modifications)
 */

public class GrowingArray
{
	private String[] words;

	private int size; // size points to next free slot in words

	private int increment;

	/**
	 * Construct a Growing Array with an initial capacity.
	 * 
	 * @param initialCapacity
	 *            The initial capacity of the array.
	 * @param increment 
	 */
	public GrowingArray(int initialCapacity, int increment)
	{
		this.words = new String[initialCapacity];
		this.size = 0;
		this.increment = increment;
	}

	/**
	 * Read in words (one per line) and store in array words, growing it as needed.
	 */
	public void readData(File file)
	{
		try
		{
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) 
			{
				// read the next word (input is one word per line)
				String word = input.nextLine();
				
				// if the array is full, increase capacity
				if (size == words.length)
				{
					growArray();
				}
				
				// store the word in the next available slot and increment size
				words[size] = word;
				size++;
			}
			input.close();
		}
		catch (FileNotFoundException e)
		{
			System.err.println("File not found: " + file);
		}
	}
	
	/**
	 * Increase capacity of internal words array.
	 */
	private void growArray()
	{
		int extra = increment;
		if (increment == 0) {
			extra = words.length; // double the size of the array
		}
		
		// copy words into new temp array
		String[] temp = new String[words.length + extra];
		for (int i = 0; i < words.length; i++)
		{
			temp[i] = words[i];
		}

		// assign temp to words (aka words is now temp)
		words = temp;
		
		System.out.println("Increased capacity to " + words.length);
	}

	/**
	 * Print words array on console.
	 */
	public void printData()
	{
		for (int i = 0; i < size; i++)
		{
			System.out.println(words[i]);
		}
	}

	public static void main(String[] args)
	{
		if (args.length != 2) {
			System.err.println("Usage: java GrowingArray <filename> <array increment>");
			System.exit(1);;
		}
		
		// Read filename from 1st command line argument
		String filename = args[0];
		File file = new File(filename);
		if(!file.exists() || !file.canRead())
		{
			System.err.println("Cannot read file: " + file);
			System.exit(1);;
		}
		
		// Read increment from 2nd command line argument
		int increment = Integer.parseInt(args[1]);
		GrowingArray example = new GrowingArray(1, increment);
		
		example.readData(new File(filename));
	}
}
