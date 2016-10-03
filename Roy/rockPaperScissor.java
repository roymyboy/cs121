import java.util.Scanner;
import java.util.Random;

public class rockPaperScissor
{
  public enum Gesture {win, lose, tie}
  
  
  private enum Move {Rock, paper, Scissor};
  
  public static void main(String[] args){
 
  String personPlay, computerPlay = "";
  int computerInt;
  int win = 0, lose = 0, tie = 0;
  
  Scanner scan = new Scanner(System.in);
  Random rand = new Random();
  
  System.out.println("Lets R, P, S.");
  
  computerInt = rand.nextInt(3)+1;
  
  if (computerInt == 1) 
    computerPlay = "R";
  else if (computerInt == 2) 
    computerPlay = "P";
   else if (computerInt == 3) 
    computerPlay = "S";
  
    for (;;) {
      //Gets player play from input
      System.out.println("Enter your play: ");
      personPlay = scan.next();
      
      //makes it all to upper case
      personPlay = personPlay.toUpperCase(); 

      
      //prints computer play
      System.out.println("Computer play is: " + computerPlay);
      
      
      //see who won the game
      
	if (personPlay.equals(computerPlay)) 
	  System.out.println("Tie"); 
	    tie++;
	  else if (personPlay.equals("R"))
	
	    if (computerPlay.equals("S")) 
	      System.out.println("Rock is over Scissor. You win!!");
	      win++;
	 else if (computerPlay.equals("P")) 
		System.out.println("Paper is over Rock. You lose!!");
		lose++;
	 else if (personPlay.equals("P"))
	    if (computerPlay.equals("S")) 
	        System.out.println("Scissor cuts paper. You lose!!");
	        lose++;
	 else if (computerPlay.equals("R")) 
		System.out.println("Paper eats rock. You win!!"); 
	 else if (personPlay.equals("S")) 
	    if (computerPlay.equals("P")) 
	    System.out.println("Scissor cuts paper. You win!!");
	    
	 else if (computerPlay.equals("R")) 
		System.out.println("Rock breaks scissors. You lose!!"); 
	 else 
	    System.out.println("Invalid user input."); 
	    
   
    }
    switch (choice) {
			case 0: {
				computerGesture = "Rock";
				break;
				}
			case 1: {
				computerGesture = "paper";
				break;
				}
			case 2: {
				computerGesture = "scissors";
				break;
				}
			default:{
				computerGesture = "What on earth was that";
				}
  }
}