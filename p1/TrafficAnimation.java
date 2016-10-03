/* 
 * TrafficAnimation.java 
 * CS 121 Project 1: Traffic Animation
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * Animates a [Watching vehicle ,moving around the road ]
 * @author [Utsav Roy]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel {
	/*
	 * Note: This area is where you declare constants and variables that
	 * need to keep their values between calls	to paintComponent().
	 * Any other variables should be declared locally, in the
	 * method where they are used.

	 * constant to regulate the frequency of Timer events
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */

	private final int DELAY = 60; //milliseconds
	//  anchor coordinate for drawing / animating

	private int x = 0;

	//  pixels added to x each time paintComponent() is called
	private int stepSize = 10;

	/* 
	 * This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics canvas) 
	{
		//  clears the previous image
		//  super.paintComponent(canvas);

		//  account for changes to window size

		int width = getWidth(); // panel width
		int height = getHeight(); // panel height



		//  	Fill the canvas with the background color
		canvas.setColor(getBackground());
		canvas.fillRect(0, 0, width, height);

		//		Calculate the new position
		x = (x + stepSize) % (width*4/3);
		int squareSide = height/5;
		int y = height/2 - squareSide/2;

		//	   Sky color
		Color skyColor = new Color(0, 255, 255);
		canvas.setColor(skyColor);
		canvas.fillRect(0, 0, width, (int)(height*0.25));

		//	    Sun Top Corner sun
		canvas.setColor(Color.YELLOW);
		canvas.fillOval(x-10, -10, (int)((x-height/8)), (int)(x-height/8));

		//	    Top ground color
		Color groundColor= new Color(0, 100, 0);
		canvas.setColor(groundColor);
		canvas.fillRect(0, (int)(y-y*0.38), width, (int)(height*0.13));

		//		Gray road
		canvas.setColor(Color.black);
		canvas.fillRect(0, (int)(y*0.94), width, (int)(height*0.32));

		//	    Bottom ground
		canvas.setColor(groundColor);
		canvas.fillRect(0, (int)(y*1.7), width, (int)(height*0.32));

		//		top dividing line
		canvas.setColor(Color.white);
		canvas.drawLine(0, (int)(height/2.67), width, (int)(height/2.67));
		canvas.drawLine(0, (int)(height/2.94)*2, width, (int)(height/2.94)*2);		

		//		Road lane: separating two lane
		canvas.setColor(Color.yellow);
		canvas.fillRect(0,(int)(y*1.28),width, (int)(height*0.015) );

		//		Top lane car: Blue
		//      Draw new square
		//		TODO: replace this square with your drawing
		int e = 150;
		canvas.setColor(Color.blue);
		canvas.fillRect(x-e, (int)(y*1.05), squareSide, squareSide/4);
		canvas.fillOval(x-e, (int)(y*0.9), squareSide, squareSide/2); //Top oval curve of the car

		//rotating arc of the wheel
		canvas.setColor(Color.DARK_GRAY); //wheel color
		canvas.fillArc(x-e, (int)(y*1.12), (int)(height/18), (int)(height/18), -x, 360); //back wheel of blue car	
		canvas.fillArc((int)((x-e)+(0.13*height)), (int)(y*1.12), (int)(height/18), (int)(height/18), -x, 360); //front wheel of the blue car
		canvas.setColor(Color.cyan);
		canvas.fillArc(x-e, (int)(y*1.12), (int)(height/18), (int)(height/18), -x, 45);
		canvas.fillArc((int)((x-e)+(0.13*height)), (int)(y*1.12), (int)(height/18), (int)(height/18), -x, 45);

		//Avatar
		int avatarW = height/10;
		int bodyY=(int) (height/(4.0/3.0));
		int bodyX = width/2 - width/15; 
		canvas.setColor(new Color(255,185,15));
		//Head
		canvas.fillOval(bodyX , bodyY, avatarW, avatarW);
		//Body
		canvas.setColor(Color.black);
		canvas.fillOval((int)(bodyX+avatarW/2.65), bodyY+ avatarW, avatarW/3, avatarW);
		//Hands
		canvas.fillOval((bodyX+avatarW/2)+(int)(avatarW*0.1), bodyY+ (int)(1.2*avatarW), avatarW, avatarW/10);
		canvas.fillOval((bodyX-(int)(0.65*avatarW))+(int)(avatarW*0.10), bodyY+ (int)(1.2*avatarW), avatarW, avatarW/10);
		//Legs
		canvas.fillOval((bodyX+avatarW/2)-(avatarW/8), bodyY+ 2*avatarW, avatarW/10, avatarW);
		canvas.fillOval((bodyX+avatarW/2)+(int)(avatarW*0.10), bodyY+ 2*avatarW, avatarW/10, avatarW);



		//Bottom lane car: Red
		canvas.setColor(Color.red);
		canvas.fillRect((-x+width), (int)(y*1.48), squareSide, squareSide/4);
		canvas.fillOval((-x+width), (int)(y*1.35), squareSide, squareSide/2); //Top oval of the bottom car

		//		Rotating wheel
		canvas.setColor(Color.DARK_GRAY); //Wheel color
		canvas.fillArc((int)((-x+width)+(height*0.01)), (int)(y*1.55), (int)(height/18), (int)(height/18), x, 360);
		canvas.fillArc((int)((-x+width)+(0.13*height)), (int)(y*1.55), (int)(height/18), (int)(height/18), x, 360);
		canvas.setColor(Color.orange);
		canvas.fillArc((int)((-x+width)+(0.13*height)), (int)(y*1.55), (int)(height/18), (int)(height/18), x, 45);
		canvas.fillArc((int)((-x+width)+(height*0.01)), (int)(y*1.55), (int)(height/18), (int)(height/18), x, 45);


		//Insert text	
		canvas.setColor(Color.red);
		canvas.setFont(new Font("Calibri", Font.BOLD, (int)(0.05*width)));

		FontMetrics metrics = canvas.getFontMetrics();         // Get Font's metrics
		Dimension d = getSize();  

		int x2 = (d.width - metrics.stringWidth("Can he cross yet?")) / 2; // Calculate coordinates
		int y2 = (d.height + metrics.getHeight()) / 2;

		canvas.drawString("Can he cross yet?", x2,(int)(y2-0.8*y2) );


	}    
	/**
	 * Constructor for the display panel initializes
	 * necessary variables. Only called once, when the
	 * program first begins.
	 * This method also sets up a Timer that will call
	 * paint() with frequency specified by the DELAY
	 * constant.
	 */
	public TrafficAnimation() 
	{
		setBackground(Color.black);
		//Do not initialize larger than 800x600
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/////////////////////////////////////////////
	// DO NOT MODIFY main() or startAnimation()
	/////////////////////////////////////////////

	/**
	 * Starting point for the TrafficAnimation program
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Create an animation thread that runs periodically
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				repaint();
			}
		};
		new Timer(DELAY, taskPerformer).start();
	}
}
