import java.util.Scanner;
import java.text.DecimalFormat;
public class FormattedDouble

{
  public static void main(String[] args)
  {
  Double length, width, area, perimeter;
  Scanner scan = new Scanner(System.in);
  
  System.out.printf("Enter the length: ");
  length = scan.nextDouble();
  
  System.out.printf("Enter the width: ");
  width = scan.nextDouble();
  area = length*width;
  perimeter = 2*(length+width);

  
  DecimalFormat fmt = new DecimalFormat(",###.##");
  System.out.println("The area of Rectangle is " + fmt.format(area));
  System.out.println("The perimeter of Rectangle is " + fmt.format(perimeter));
  }
}