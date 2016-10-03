import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 * Demonstrates the use of one listener for multiple buttons.
 * 
 * @author Java Foundations
 */

	@SuppressWarnings("serial")
	public class UpDown extends JPanel
	{
		private JButton Up, Down;
		private JLabel label, number;
		private JPanel UpDown;
		int num = 50;
		  
		// Constructor
		public UpDown()
		{
			Up = new JButton("Up");
			Down = new JButton("Down");
			number = new JLabel("Number: " + num++);

			ButtonListener listener = new ButtonListener();
			Up.addActionListener(listener);
			Down.addActionListener(listener);

			label = new JLabel("Push a button");
			

			UpDown = new JPanel();
			UpDown.setPreferredSize(new Dimension(200, 40));
			UpDown.setBackground(Color.blue);
			UpDown.add(Up);
			UpDown.add(Down);

			setPreferredSize(new Dimension(200, 80));
			setBackground(Color.cyan);
			add(label);
			add(UpDown);
			add(number);
			
		}

		/**
		 * Represents a listener for both buttons.
		 */
		private class ButtonListener implements ActionListener
		{
			/**
			 * Determines which button was pressed and sets the label
			 * text accordingly.
			 */
			public void actionPerformed(ActionEvent event)
			{
				if (event.getSource() == Up)
				{
					number.setText("Number: " + num++);
				}
				else
				{
					number.setText("Number: " + --num);
				}
			}
		}
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Up Down");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().add(new UpDown());

		frame.pack();
		frame.setVisible(true);
	}
}


