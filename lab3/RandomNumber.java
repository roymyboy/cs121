import java.util.Random;
public class RandomNumber

{

public static void main(String[] args)
	{
 	Random generator = new Random();
	int num1;
	
	num1 = generator.nextInt();
	System.out.println("A random integer: "+ num1);
	
	num1 = generator.nextInt(20);
	System.out.println("From 0 to 19: "+ num1);

	num1 = generator.nextInt(8)+1;
	System.out.println("From 1 to 8: "+ num1);

	num1 = generator.nextInt(45)+10;
	System.out.println("From 10 to 54: "+ num1);
	
	num1 = generator.nextInt(100)-50;
	System.out.println("From -50 to 49: "+ num1);
	
	}
}