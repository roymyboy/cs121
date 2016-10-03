import java.util.Random;
import java.text.DecimalFormat;

public class BoxTest 
{
  public static void main(String[] args) {
	 double width = 4, height = 5, depth = 2;
	 
	 //creating new BoxTest
	 
	 DecimalFormat fmt = new DecimalFormat("0.00");
	 
	 Box smallBox = new Box(width, height, depth);
	 System.out.print("SmallBox: "+  smallBox.toString());
	 System.out.println("SurfaceArea: " + fmt.format(smallBox.surfaceArea()) + 
			    ", Volume: " + fmt.format(smallBox.Volume()) + ".");
			    
	 //using setter method
	 smallBox.setWidth(2);
	 smallBox.setHeight(3);
	 smallBox.setDepth(1);
	 smallBox.setFull(true);
	 
	 System.out.println();
	 System.out.print("SmallBox: " + smallBox.toString());
	 System.out.println("SurfaceArea: " + fmt.format(smallBox.surfaceArea()) + 
			    ", Volume: " + fmt.format(smallBox.Volume()) + ".");
			    
	System.out.println();
			    
	//printing out several boxes
	Random rand = new Random();
	
	Box BoxMax = new Box(0, 0, 0);
	double mav_Volume = 0;
	
	for (int i = 1; i <= 5; i++) {
	
	width = rand.nextDouble();
	height = rand.nextDouble();
	depth = rand.nextDouble();
	boolean full = rand.nextBoolean();
	
	Box Box1 = new Box(width, height, depth);
	Box1.setFull(full);
	
	Box1.setName("Box" + i + ":");
	System.out.print(Box1.toString());
	System.out.println("SurfaceArea: " + fmt.format(Box1.surfaceArea()) + 
			    ", Volume: " + fmt.format(Box1.Volume()) + ".");
			    
	
	if(Box1.Volume() > BoxMax.Volume()){
		BoxMax = Box1;	
	  }
	}
	System.out.println();
	System.out.println("Largest Value: " + BoxMax.toString());
	
	
  }

}