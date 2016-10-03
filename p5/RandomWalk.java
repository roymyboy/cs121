import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 *@author utroy
 *
 */

public class RandomWalk
{
	//attributes 
	private int size_Grid;
	private boolean done;
	private Random rand;
	private long seed;
	private Point start_Point;
	private Point end_Point;
	private Point local;
	ArrayList<Point> path;

	/**
	 * constructor 
	 * Initializes the instance variables and the starting point of the walk,
	 * Doesnot create the walk creates the randon number generator without seed.
	 */

	public RandomWalk(int size_Grid)
	{
		rand = new Random();
		this.size_Grid = size_Grid;
		start_Point = new Point(0, 0);
		path = new ArrayList<Point>();
		path.add(start_Point);
		end_Point = new Point(size_Grid-1, size_Grid-1);
		done = false; 
	}

	/**
	 *constructor 
	 * Initializes the instance variables and the starting point of the walk,
	 * Doesnot create the walk creates the randon number generator with seed.
	 *
	 */

	public RandomWalk(int size_Grid, long seed)
	{
		rand = new Random(seed);
		this.size_Grid = size_Grid;
		this.seed = seed;
		start_Point = new Point(0, 0);
		path = new ArrayList<Point>();
		path.add(start_Point);
		end_Point = new Point(size_Grid-1, size_Grid-1);
		done = false;     
	}



	/**
	 *
	 * @param checks for the starting point and 
	 * checks for the right point to move to the end of the grid map.  
	 */

	public void createWalk()
	{
		while (!done)
		{
			step();
		}
	}
	/**
	 * If the path is stuck, clear the path and reset to starting point [0,0]
	 */

	public boolean ifStuck()
	{
		local = path.get(path.size()-1);
		if (local.x-1 >= 0)
		{
			if(!path.contains(new Point(local.x-1,local.y)))
			{
				return false;
			}
		}
		if (local.x+1 <= end_Point.x)
		{
			if(!path.contains(new Point(local.x+1,local.y)))
			{
				return false;
			}
		}
		if (local.y-1 >= 0)
		{
			if(!path.contains(new Point(local.x,local.y-1)))
			{
				return false;
			}
		}
		if (local.y+1 <= end_Point.y)
		{
			if(!path.contains(new Point(local.x,local.y+1)))
			{
				return false;
			}
		}
		return true;

	}

	/**
	 * crestes one more step and further called by the createWalk method. 
	 * Checks if is stuck and sets the starting point to [0,0]
	 *
	 */

	public  void step()
	{
		local = path.get(path.size()-1);
		int choice = rand.nextInt(4);
		if (choice == 1) 
		{
			if (local.x < end_Point.x) 
			{
				local = new Point(local.x+1, local.y);

				if (!path.contains(local))
				{
					path.add(local);
				}

			}
			} else
			{
				if (local.y < end_Point.y) {
					local = new Point(local.x, local.y + 1);
					path.add(local);
					return;
				}
			}


				if (local.x == end_Point.x && local.y == end_Point.y) {
					done = true;
				}
			}



			/**
			 *
			 * return true if the random is complete
			 */

			public boolean isDone()
			{
				return done;
			}

			/**
			 *
			 *returns path as it creats moving forward
			 */

			public ArrayList<Point> getPath()
			{
				return path;
			}
			
			public Point getPoint(int index)
			{
				return path.get(index);
			}

			/**
			 *
			 * makes the correct format to the grid point
			 */

			public String toString()
			{
				String pa = "";


				for (Point p:path)
				{
					pa += "[" + p.x + ", " + p.y +"]";
				}
				return pa;
			}

		}