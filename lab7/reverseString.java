public class reverseString;
{
  public String reverse(String str){
    
    StringBuilder Turn_ln = new StringBuilder();
  
    int length = str.length();
    
    for (int i = length; i !=0; i--) {
       Turn_ln.append(str.charAt(i-1));
    }
	return Turn_ln.toString;
 }
  
}