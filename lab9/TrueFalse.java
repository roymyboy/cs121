import java.util.Scanner;
import java.util.Arrays;

public class TrueFalse
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
  
		System.out.print("Enter an integer for the size of an array: ");
		int array_Size = scan.nextInt();
  
		boolean[] flags;
		flags = new boolean[array_Size];
		int[] a = new int[array_Size];
  
		for (int i=0; i <= a.length-1; i++)
		{	
			if (i % 2 == 0)
			{		
				flags[i]= true;
			} else
			{
				flags[i] = false;
			}
				
		}
		for(int i = 0; i <= array_Size-1; i++ )
		{
			System.out.println(flags[i]);
		}
	}
}