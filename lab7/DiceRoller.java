import java.util.Scanner;

/**
 * This program plays dice roll game with computer and user and
 * keeps track of all win, loss and ties
 * @author utroy
 *
 */
public class DiceRoller
{
  /**
 * @param args
 */
public static void main(String[] args)
  {
	int user_wins = 0, Computer_wins = 0, ties = 0, reson_Val= 6;
	String goAhead = "y";
	Scanner scan = new Scanner(System.in);
	
	while(goAhead.equalsIgnoreCase("y")){
	  PairOfDice D_ie = new PairOfDice(reson_Val);
	 
	  int user = D_ie.roll();
	  System.out.print("Your roll: " + D_ie.toString());
	  
	  int computer = D_ie.roll();
	  System.out.print("\n" + "Computer's roll: " + D_ie.toString());
	  
	    if (user > computer){
		System.out.print("\n" + "You win!");
		user_wins++;
	    } if (user < computer){
		System.out.print("\n" + "You lose!");
		Computer_wins++;
	    } else if ( user == computer) {
		System.out.print("\n" + "It's a tie!");
		ties++;
	    }
	  System.out.print("\n" + "Your Wins: " + user_wins + "  Computer's wins: " 
			   + Computer_wins + "  Ties: " + ties);
		
	System.out.print("\n" + "Do you want to roll again? (Y)es to continue, anything else to quit: ");
	goAhead = scan.nextLine();
	goAhead = goAhead.substring(0,1);
	
	}
	System.out.println("Thank's for playing!" );
  }
}