import java.text.DecimalFormat;

public class Box{

  /**
  * instance variables
  */
  private double width, height, depth, Volume, surfaceArea;
  private boolean full;
  private String name;
  
  /**
  * Constructor
  * @param width, box width
  * @param height, box width
  * @param depth, box width
  */
  
  /**
  * creates a new box
  */
  
  public Box( double width, double height, double depth)
  {
   this.width = width;
   this.height = height;
   this.depth = depth;
   full = false;
  }
  
  
   /**
  * @return name of the box
  */
  
  public String getName()
  {
    return name;
  }
  
   /**
  * @param name of the box
  */
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  /**
  * @return width of the box
  */
  
  public double getWidth()
  {
    return width;
  }
  
   /**
  * @param width of the box
  */
  
  public void setWidth(double width)
  {
    this.width = width;
  }

  /**
  * @return height of the box
  */
  
  public double getHeight()
  {
    return height;
  }
  
  /**
  * @param height of the box
  */
  
  public void setHeight(double height)
  {
    this.height = height;
  }
  
  /**
  * @return depth of the box
  */
  
  public double getDepth()
  {
    return depth;
  }
  
  /**
  * @param depth of the box
  */
  
  public void setDepth(double depth)
  {
    this.depth = depth;
  }
  
  /**
  * @return boolean 
  */
  
  public boolean getFull()
  {
    return full;
  }
  
  /**
  * @param full 
  */
  
  public void setFull(boolean newFull) 
  {
     full = newFull;
  }
  
   /**
  * Calculates Volume
  * @return Volume
  */
  
  public double Volume()
  {
      return depth*height*width;
  }
  
  
  /**
  * Calculates surface area
  * @return surface area
  */
  
  public double surfaceArea()
  {
      return 2.0 *(width*depth + height*depth + width*height);
  }
  
   DecimalFormat fmt = new DecimalFormat("0.00");
  // toString()
   public String toString()
   {
    return (name + " width: " + fmt.format(width) 
	    + ", height: "+ fmt.format(height) + ", depth: " 
	    + fmt.format(depth) + ", full: "+ full + ", ");
   }
}