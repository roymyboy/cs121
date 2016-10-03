public class oddInt

{
public static void main(String[] args)
  {
      final int startVal = 1, endVal = 99, perLine = 5;
      int odd, count = 0 ;
      
      System.out.println("The odd number from " + startVal + " to " + endVal + " are: ");
      
      for (odd = startVal; odd <= endVal; odd += startVal +1) {
      System.out.print(odd +"\t");
      
      count++; //prints specific number of value per line
      
      if ( count % perLine == 0 ) {
       System.out.println(); 
      }
    }
    System.out.println();
  }
}