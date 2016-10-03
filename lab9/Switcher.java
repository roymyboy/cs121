import java.util.Scanner;
import java.util.Arrays;

public class Switcher
{
	public static boolean switchThem(int[] x, int[] y)
	{
		int a1 = x.length;
		int a2 = y.length;
		int[] val = new int[a1];
		
		if (a1 == a2)
		{
			for(int i = 0; i<= a1-1; i++)
			{
				val[i] =    x[i];
				x[i]  =    y[i];
				y[i]   = val[i];
			}
			return true;
		}
		    return false;
	}
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the size of x1: ");
		int x1_Size = scan.nextInt();
		
		System.out.print("Enter the size of y1: ");
		int y1_Size = scan.nextInt();
		
		int[] x1 = new int[x1_Size];
		int[] y1 = new int[y1_Size];
		
		for (int i = 0; i <= x1.length-1; i++)
		{
			x1[i] = (int) (Math.random()*x1_Size);
			System.out.println(x1[i]);	
		}
		
		System.out.println("");
		
		for (int i = 0; i <= y1.length-1; i++)
		{
			y1[i] = (int) (Math.random()*y1_Size);
			System.out.println(y1[i]);
		}
		
		System.out.println(switchThem(x1, y1));
		System.out.println("");
		
		for (int i = 0; i <= x1.length-1; i++)
		{
			System.out.println(x1[i]);
	}
		System.out.println("");
		
		for (int i = 0; i <= y1.length-1; i++)
		{
			System.out.println(y1[i]);
		}
	}
	
}