import java.util.Scanner;
import java.util.Random;

/**
 * PP 4.13: Rock, Paper, Scissors Game.
 *
 * @author
 */
public class RockPaperScissors
{
	public enum Player {COMPUTER, YOU, TIE};

	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();

		Gesture computerGesture = null, yourGesture = null;
		Player winner;

		int wins = 0, losses = 0, ties = 0;
		String another = "y";
		

		while (another.equalsIgnoreCase("y")) {
			// computer chooses
			// TODO: Change the following statement so it makes
			// a random choice. (Hint: You can get the number of
			// gestures to choose from using Gesture.values().length).
			int choice = rand.nextInt(Gesture.values().length); //use Random here
			boolean goahead = true; 
			// TODO: Use a switch statement to assign corresponding
			// Gesture enum value to the computerGesture variable
			switch (choice) {
			case 0:  {
				computerGesture = Gesture.ROCK;
				break;
			}
			case 1:  { 
				computerGesture = Gesture.PAPER;
				break;
			}
			case 2:  {
				computerGesture = Gesture.SCISSORS;
				break;
			}	
			default: {
				computerGesture = null;
			}
			}

			// TODO: Print a menu of all available gestures using a
			// for-each loop that iterates over Gesture.values()
			System.out.println("Select your gesture:");
			for(Gesture move: Gesture.values())
			{
				System.out.println(move.ordinal() + " for " + move);
			}
			System.out.println();

			// player chooses
			System.out.println("Play your move: ");
			choice = scan.nextInt();
			scan.nextLine();
			// TODO: Use a switch statement to assign corresponding
			// Gesture enum value to the yourGesture variable
			switch(choice) {
			case 0: {
				yourGesture = Gesture.ROCK;
				break;
			}
			case 1: {
				yourGesture = Gesture.PAPER;
				break;
			}
			case 2: {
				yourGesture = Gesture.SCISSORS; 
				break;

				}
			default  :
				System.out.println("invalid Gesture");
				goahead = false;
			}
            if (goahead){
			// clear the scan buffer

			System.out.println("I chose " + computerGesture + ".");
			System.out.println("You chose " + yourGesture + ".");

			// TODO: Determine the winner. Set the winner variable
			// to the correct Player.
			// You can use nested if-else statements or nested
			// switch statements
			if (yourGesture.equals(computerGesture)) {
				System.out.println("Tie"); 
				ties++;
			}
			else if (yourGesture.equals(Gesture.ROCK)){
				if (computerGesture.equals(Gesture.SCISSORS)){
					System.out.println("Rock is over Scissor. You win!!");
					wins++;
				}
				else if (computerGesture.equals(Gesture.PAPER)) //{ 
					System.out.println("Paper is over Rock. You lose!!");
				losses++;
			}
			else if (yourGesture.equals(Gesture.PAPER)) {
				if (computerGesture.equals(Gesture.SCISSORS)) 
					System.out.println("Scissor cuts paper. You lose!!");
				losses++;}
			else if (computerGesture.equals(Gesture.ROCK)) {
				System.out.println("Paper eats rock. You win!!");
				wins++;
			}
			else if (yourGesture.equals(Gesture.SCISSORS)) { 
				if (computerGesture.equals(Gesture.PAPER)) 
					System.out.println("Scissor cuts paper. You win!!");
				wins++;}
			else if (computerGesture.equals(Gesture.ROCK)){ 
				System.out.println("Rock wins scissors. You lose!!");
				losses++;}
		
		   else if (yourGesture != computerGesture)
			System.out.println("Invalid gesture."); 
		
            }
			
				System.out.print("Would you like to choose another (y/n)?");
				another = scan.nextLine();
				another = another.substring(0,1);

			if (another.equalsIgnoreCase("n")){
				System.out.println();
				System.out.println("You won " + wins + " times");
				System.out.println("You lost " + losses + " times");
				System.out.println("You tied " + ties + " times");
			} 
		}
	}

	// TODO: Print who won and increment appropriate counter.
	// Use a switch statement on the value of winner.
	// (e.g. switch(winner) { ... }).

	// TODO: Ask if they want to play again and loop back to the
	// top if they do. Print a table of final results before
	// exiting if they decide they are done playing.
}
