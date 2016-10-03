import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Prompt for a file to echo. Read the file and prints only caplital letters 
 * 
 * @author utroy
 */
public class ParseForCaps 
{

	public static final int ERROR_CODE = 1;

	/**
	 * @param args unused
	 */
	public static void main(String[] args) 
	{
		// keyboard Scanner
		String upper_case = "";
		Scanner kbd = new Scanner(System.in);
		
		System.out.print("Enter a file name: ");
		String fileName = kbd.nextLine().trim();

		//creating s new file
		
		File file = new File(fileName);
		
		//file in a Scanner
		//opening a File has the potential to fail (the file might not exist or might not have permission
		// to read the file, etc.) so to deal with the FileNotFoundException that could be thrown
		// if can't open the File for any reason. The try-catch way of handling Exceptions
		// here, because it allows to print a helpful message before exiting rather than letting the program crash.
		
		try 
		{
			Scanner fileScan = new Scanner(file);
			//if we succeeded in opening the File in fileScan, we can continue, here - otherwise we will catch the
			// FileNotFoundException in the catch block, below
			
			System.out.println("\nContents of \"" + fileName + "\":\n");
			
			//read in each line of the file with fileScan until we run out of lines
			//Note - if our intent is to read whole lines, it is important that we use the hasNextLine() and nextLine()
			// methods rather than the hasNext() and next() methods, which gives only one token (word) at a time - 
			// mixing these kinds of methods with a single Scanner leads to trouble

			while (fileScan.hasNextLine()) 
			{			
				//read file
				
				String line = fileScan.nextLine();
				for(int i= 0; i<line.length(); i++)
				{
				  char ch = line.charAt(i);
				  if (Character.isUpperCase(ch))
				  {
				    upper_case += ch;
				  }
				}	
			}
			fileScan.close();
		} 	catch (FileNotFoundException e) 
			{
			//print a helpful message before exiting
			//block of code if a FileNotFoundException was thrown while trying to open
			//the file in fileScan, above

			System.out.println("File \"" + fileName + "\" could not be opened.");
			System.out.println(e.getMessage());
			System.exit(ERROR_CODE);
			}
		System.out.println("Capital first letters: " + upper_case );
	}
}
