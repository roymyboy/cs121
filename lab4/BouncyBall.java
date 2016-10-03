
//BouncyBall.java
//
//Example using Random and conditional statements
//CS 121
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.Math;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/** Animated program with a ball bouncing off the program boundaries
 * @author Utsav Roy
 */
public class BouncyBall extends JPanel {
	private final int INIT_WIDTH = 600;
	private final int INIT_HEIGHT = 400;
	private final int DELAY = 10 ; // milliseconds between Timer events
	private Random rand; //random number generator
	private int x, y; //anchor point coordinates
	private int xDelta, yDelta, rDelta; //change in x and y from one step to the next
	private final int DELTA_RANGE = 20; //range for xDelta and yDelta
	private int radius= 10; //circle radius
	private int red, green, blue;
        private final int rDelta_MIN = INIT_HEIGHT/10;
	private final int rDelta_MAX = INIT_HEIGHT;
	/**
	 * Draws a filled oval with random color and dimensions.
	 * 
	 * @param g Graphics context
	 * @return none
	 */	 
	public void paintComponent(Graphics g) {
	
	//super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		
		radius = rand.nextInt(10)+0;
		//clear canvas
		//g.setColor(getBackground());
		//g.fillRect(0, 0, width, height);
		
		//CALCULATE NEW X
		x += xDelta;
		//TODO: needs more to stay in-bounds
		
		//CALCULATE NEW Y
		y += yDelta;

		//TODO: needs more to stay in-bounds
		
		//calculate new radius
		radius += rDelta;
		
		// bounce within the x-axis
		if (x >= width - radius) {
			xDelta = -xDelta;
			x = width - radius;
			//x += xDelta;
		} else if (x <= radius) {
			xDelta = -xDelta;
			x = radius;
			//x += xDelta;
		}
		// bounce within the y-axis
		if (y >= height -radius) {
			yDelta = -yDelta;
			y = height - radius;
		} else if (y <= radius) {
		        yDelta = -yDelta;
		        y = radius;
		}
		//change in radius
		if (radius >= rDelta_MAX) {
			rDelta = -rDelta;
			//radius = rDelta_MAX;
		} else if (radius <= rDelta_MIN ) {
			rDelta = -rDelta;
			//radius = -rDelta_MIN;
		}
			
		
		
		//NOW PAINT THE OVAL
		red = rand.nextInt(256);
		green = rand.nextInt(256);
		blue = rand.nextInt(256);
		Color color = new Color( red, green, blue);
		
		g.setColor(color);
		g.fillOval(x-radius, y-radius, 2*radius, 2*radius);
		//Makes the animation smoother
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public BouncyBall()
	{
		setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
		this.setDoubleBuffered(true);
		setBackground(Color.black);

		rand = new Random(); //instance variable for reuse in paint()
		
		//initial ball location within panel bounds
		x = rand.nextInt(INIT_WIDTH-radius) + 0;
		y = rand.nextInt(INIT_HEIGHT-radius) + 0;
		//TODO: replace centered starting point with a random
		// position anywhere in-bounds - the ball should never
		// extend out of bounds, so you'll need to take RADIUS
		// into account

		//deltas for x and y
		xDelta = rand.nextInt(DELTA_RANGE)-DELTA_RANGE/2;
		yDelta = rand.nextInt(DELTA_RANGE) - DELTA_RANGE/2;
		rDelta = INIT_HEIGHT/80;
		//TODO: replace with random deltas from -DELTA_RANGE/2
		// to +DELTA_RANGE/2
		


		//Start the animation - DO NOT REMOVE
		startAnimation();
		setPreferredSize(new Dimension(600, 400));
		

	}

	/**
	 * Create an animation thread that runs periodically
	 * DO NOT MODIFY
	 */
	private void startAnimation() {
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}
	
	/**
	 * Starting point for the BouncyBall program
	 * DO NOT MODIFY
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Bouncy Ball");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BouncyBall());
		frame.pack();
		frame.setVisible(true);
	}

}
