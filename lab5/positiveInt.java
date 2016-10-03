import java.util.Scanner;

public class positiveInt
{

  public static void main(String[] args){
  
  Scanner in = new Scanner(System.in);
  
  int inInt; 
  int Largest_Int = 0;
  
  
  do {
  System.out.print("Enter a positive integer: ");
    inInt = in.nextInt();
  
  if (inInt > Largest_Int) {
  Largest_Int = inInt;
  }
  
  } while (inInt >= 1);
  
  System.out.println("Largest integer entered was: " + Largest_Int);
  
   
  }
}