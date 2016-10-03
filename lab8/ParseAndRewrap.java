import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.text.PlainDocument;

/**
 * Prompt for a file to read. 
 * 
 * 
 * @author utroy
 */
public class ParseAndRewrap 
{

	public static final int ERROR_CODE = 1;

	/**
	 * @param args unused
	 */
	public static void main(String[] args) 
	{

		// keyboard Scanner
		String re_Formatted = ""; 
		int max = 0;
		int min = Integer.MAX_VALUE;
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Please enter a plain text file name: ");
		String fileName = kbd.nextLine().trim();
		
		System.out.print("\n" + "Please enter the maximum number of characters in a single line: ");
		int num_perLine = kbd.nextInt();

		//create a File object

		File file = new File(fileName);
		
		// open the file in a Scanner
		// Note - opening a File has the potential to fail (the file might not exist, you might not have permission
		// to read the file, etc.) so Java requires you to deal with the FileNotFoundException that could be thrown
		// if you can't open the File for any reason. We are demonstrating the try-catch way of handling Exceptions
		// here, because it allows you to print a helpful message before exiting rather than letting the program crash.

		try 
		{
			Scanner fileScan = new Scanner(file);

			//if succeeded in opening the File in fileScan, we can continue, here - otherwise it will catch the
			// FileNotFoundException in the catch block, below
			
			System.out.println("\n" + fileName + " reformatted with maximum line length: " + num_perLine + "\":\n");
			
			//read in each line of the file with fileScan until we run out of lines
			//Note - if our intent is to read whole lines, it is important that we use the hasNextLine() and nextLine()
			//methods rather than the hasNext() and next() methods, // which give us only one token (word) at a time - 
			//mixing these kinds of methods with a single Scanner leads to trouble

			while (fileScan.hasNextLine()) 
			{
				//read one line
				String line = fileScan.nextLine();
				
				//new scanner
				Scanner lineScan = new Scanner(line);

				while (lineScan.hasNext()) 
				{
					//read the next token/word
					String token = lineScan.next();

						if(re_Formatted.length() + token.length() > num_perLine)
						{
						    if (re_Formatted.length() < min) 
						    {
							min = re_Formatted.length();
						    }
						    if (re_Formatted.length() > max)
						    {
						      max = re_Formatted.length();
						    }
						    System.out.println(re_Formatted);
						    re_Formatted = "";
						}
						re_Formatted += token + " ";
						
					
					
					
				}
				lineScan.close();
			}
			    min = re_Formatted.length();
			    System.out.println(re_Formatted);
			
			
			fileScan.close();
		} catch (FileNotFoundException e) 
		{

			//print a helpful message before exiting

			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(ERROR_CODE); // exit the program with an error status
		}
		
		
		System.out.println("\n"+"Longest line: " + (max-1));
		System.out.println("Shortest line: " + (min));
	}
}