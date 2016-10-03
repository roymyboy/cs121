import java.util.Scanner;
public class ConvertToHours
{
  public static void main(String[] args)
  {
    Scanner output = new Scanner(System.in);
    int Hours = 0, Minutes = 0, Seconds=0, totalSeconds = 0; 
    Double totalHours = 0.0;
    
    System.out.print("Please enter the Total Seconds you want to convert: ");
    totalSeconds = output.nextInt();
    
    Hours = (totalSeconds/(60*60));
    Minutes = ((totalSeconds % (60*60))/60);
    Seconds = ((totalSeconds % (60*60))%60);
    totalHours = (((double) totalSeconds)/(60*60));
    
    System.out.println("Hours: " + Hours);
    System.out.println("Minutes: " + Minutes);
    System.out.println("Seconds: " + Seconds);
    System.out.println("Total Hours: " + totalHours);
     
    
  }
}