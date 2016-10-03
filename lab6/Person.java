/**
* Person
* @author Utsav Roy
*/

public class Person
{
    /* instance variable */
    private String name;
  
  /**
  * creates a person's name 
  */
    public Person(String name) {
      this.name = name;
    }
 
  /**
  *@return name 
  */
    public String getName() {
      return this.name = name;
    }
 
  /**
  * @param name
  */
    public void setName(String name){
      this.name = name;
    }
   //to string 
   
   public String toString(){
      return "Person [name=" + this.name +"]";  
   }
}