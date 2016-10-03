mport java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessText 
{
	public static void main(String[] args) 
	{
		int count = 0;
		
		//Printing out error message 
		if (args.length == 0)
		{              
			System.out.println();
			System.out.println("Usage: java ProcessText file1 [file2 ....]");
			System.out.println();
			
		}
		//Creating and printing
		for (int i = 0; i < args.length; i++) 
		{
			File file = new File(args[i]);
			TextStatistics readFile = new TextStatistics(file);
			System.out.println(readFile.toString()); 
		}
	
	}
}

