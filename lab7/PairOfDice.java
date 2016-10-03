import java.util.Random;

/**
 * Manages a pair of dice
 * @author utroy
 *
 */
public class PairOfDice{
      private Die die1, die2;
      Random rand;
     
      
     /**
     * Constructor: Creates two default dice
     * @param numSides
     */
    public PairOfDice(int numSides)
      {
	    die1 = new Die(numSides);
	    die2 = new Die(numSides);
      }
	    
      /**
       * this method rolls two dice using two seed method
     * @param numSides
     * @param seed1
     * @param seed2
     */
    public PairOfDice(int numSides, long seed1, long seed2)
      {	    
	    rand = new Random(seed1);
	    rand = new Random(seed2);
	    die1 = new Die(numSides, seed1);
	    die2 = new Die(numSides, seed2);
      }
      /**
     * Roll both dice and return the total
     * @return sum of new face value
     */
    public int roll()
      {
	    die1.roll();
	    die2.roll();
	    
	    return die1.getFaceValue() + die2.getFaceValue();
      }
      /**
     * @return current sum of the two face values
     */
    public int getTotal()
      {
	    int total = die1.getFaceValue() + die2.getFaceValue();
	    return total;
      }
      /**
     * @return current face value from first Die
     */
    public int getFaceValue1()
      {
	    int faceValue1 = die1.getFaceValue();
	    return faceValue1;
      }
      /**
     * @return current face value from second Die
     */
    public int getFaceValue2()
      {
	    int faceValue2 = die2.getFaceValue();
	    return faceValue2;
      }
	    
    public String toString()
      {
	    return ((die1.getFaceValue() + die2.getFaceValue()) + "(" 
		    + die1.getFaceValue() + " + " + die2.getFaceValue() + ")" );
      }




}