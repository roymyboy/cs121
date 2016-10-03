public class Mood
{
  enum mood { happy, bored, excited, snarky, zombie, grumpy, calm}

  public static void main(String[] args) {
  
  mood Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday;
  
  Sunday = mood.happy;
  Monday = mood.bored;
  Tuesday = mood.excited;
  Wednesday = mood.snarky;
  Thursday = mood.zombie;
  Friday = mood.grumpy;
  Saturday = mood.calm;
  
  System.out.println("On Sunday, I am " + Sunday + "." );
  System.out.println("On Monday, I am " + Monday + ".");
  System.out.println("On Tuesday, I am " +Tuesday + "." );
  System.out.println("On Wednesday, I am " + Wednesday + "." );
  System.out.println("On Thursday, I am " + Thursday + "." );
  System.out.println("On Friday, I am " + Friday + ".");
  System.out.println("On Saturday, I am " + Saturday + "." );
  
  }
}