import java.util.Random;
/**
 * Die.java       Java Foundations
 *
 * Represents one die (singular of dice) with faces showing values
 * between 1 and 6.
*/

public class Die
{
   private final int Default_Max = 6; // maximum face value
   Random random = new Random();
   private int numSides;  
   private long seed;
   private int faceValue;  // current value showing on the die

   
   /**
    * Constructor: Sets the initial face value of this die.
    */
     public Die()
   {
      this.numSides = Default_Max;
      this.faceValue = 1;
      this.random = new Random();
   }
   
   public Die(int numSides)
   {
      this.numSides = numSides;
      this.faceValue = 1;
      this.random = new Random();
      
   }
   
   public Die(int numSides, long seed)
   {
      this.numSides = numSides;
      this.faceValue = 1;
      this.random = new Random();
      this.seed = seed;
      this.random = new Random(seed);
   }

   /**
    * Computes a new face value for this die and returns the result.
    * @return The new face value.
    */
   public int roll()
   {
     
	  //int faceValue = 5; //hides the instance variable!
      faceValue = (int)(random.nextDouble() * numSides) + 1;

      return faceValue;
   }
   
   

   /**
    * Face value mutator. The face value is not modified if the
    * specified value is not valid.
    * 
    * @param value The new face value. Must be between 1 and max face 
    * value.
    */
   public void setFaceValue (int value)
   {
      if (value > 0 && value <= Default_Max)
         faceValue = value;
   }

   /**
    * Face value accessor.
    * @return The current face value.
    */
   public int getFaceValue()
   {
	   return faceValue;
   }

   /**
    * Returns a string representation of this die.
    */
   public String toString()
   {
      String result = Integer.toString(faceValue);
      //String result = "Die: [faceValue = " + faceValue + "]";

      return result;
   }
}
