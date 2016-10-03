/**
* How many seconds are there in 1 day 6 hour 42 min and 11 seconds
*/
import java.util.Scanner;
public class scanner
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int days = 0, hours = 0, minutes = 0, seconds = 0;
    
    System.out.print("Please enter the days: ");
    days = input.nextInt();
    
    System.out.print("Please enter the hours: ");
    hours = input.nextInt();
    
    System.out.print("Please enter the minutes: ");
    minutes= input.nextInt();
    
    System.out.print("Please enter the seconds: ");
    seconds = input.nextInt();
    
    hours += (days*24);
    minutes += (hours*60);
    seconds += (minutes*60);
    
    System.out.println("The total number of seconds is: " + seconds);
   
    //System.out.print("Please enter the crediential---> ");
    //String sentence = fromKey.next();
    //char word = sentence.charAt(4);
    //System.out.println("this is scanner class: " + word );
  }
}