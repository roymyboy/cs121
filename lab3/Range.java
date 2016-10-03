import java.util.Random;
public class Range

{

public static void main(String[] args)
	{
 	Random generator = new Random();
	int num1;
	
	num1 = generator.nextInt();
	System.out.println("A random integer: "+ num1);
	
	num1 = generator.nextInt(11);
	System.out.println("From 0 to 10: "+ num1);

	num1 = generator.nextInt(501);
	System.out.println("From 0 to 500: "+ num1);

	num1 = generator.nextInt(10)+1;
	System.out.println("From 1 to 10: "+ num1);
	
	num1 = generator.nextInt(500)+1;
	System.out.println("From 1 to 500: "+ num1);
	
	num1 = generator.nextInt(26)+25;
	System.out.println("From 25 to 50: "+ num1);
	
	num1 = generator.nextInt(26)-10;
	System.out.println("From -10 to 15: "+ num1);
	
	}
}
