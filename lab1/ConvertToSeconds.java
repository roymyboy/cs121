import java.util.Scanner;
public class ConvertToSeconds
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int Hours = 0, Minutes = 0, Seconds = 0;
   
    System.out.print("Enetr the number of Hours: ");
    Hours = input.nextInt();
    
    System.out.print("Enetr the number of Minutes: ");
    Minutes = input.nextInt();
    
    System.out.print("Enetr the number of Seconds: ");
    Seconds = input.nextInt();
    
    Minutes += (Hours*60);
    Seconds += (Minutes*60);
   
    System.out.println("The total amount of seconds in the given data is: " + Seconds );
   
  }
}