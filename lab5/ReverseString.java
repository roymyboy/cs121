import java.util.Scanner;

public class ReverseString {

public static void main(String[] args){

    Scanner scan = new Scanner(System.in);
    String reserve;
    
    StringBuilder Turn_ln = new StringBuilder();
    
    System.out.println("Enter a String: ");
    reserve = scan.nextLine();
    
    int length = reserve.length();
    
    for (int i = length; i !=0; i--) {
       Turn_ln.append(reserve.charAt(i-1));
    }
     System.out.println(Turn_ln);





 }
}