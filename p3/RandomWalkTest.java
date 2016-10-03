import java.util.Scanner;

/**
 * This application is intended to collect user input and manage it.
 * @author utroy
 */
public class RandomWalkTest
{
	private static int grid_Size;
	private static long seed = -1;
	
		
	/**
	 * Dealing with user input
	 */
	private static void getInput() 
	{
	    Scanner scan = new Scanner(System.in);
		
		//Ask user for grid size if the grid size is entered 0 <=, user will be asked to re-enter
		//higher value
		while (grid_Size <= 0) {
			System.out.print("\n" + "Please enter the grid size: ");
			grid_Size = scan.nextInt();
	     
			if (grid_Size <= 0){
			System.out.print("\n" + "Error: grid size must be more than 0!");  
			}
		}
		
		//Ask user for grid size if the grid size is entered 0<, user will be asked to re-enter
		//higher value
		while (seed < 0){
			System.out.print("\n" + "Enter random seed (0 for no seed): ");
			seed = scan.nextLong();
	      
			if (seed < 0){
			System.out.print("\n" + "Error: random seed must be 0 or more than 0: ");
			}
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// call getInput to process user input
		getInput();
		
		RandomWalk w;
		// create RandomWalk object using the appropriate constructor
		
		if (seed == 0) {
		  w = new RandomWalk(grid_Size);
		} else {
		  w = new RandomWalk(grid_Size, seed);
		}
		// create the random walk and then print it
		w.createWalk();
		
		
		System.out.println(w.toString() + "\t");
		
		

		
	}
}
