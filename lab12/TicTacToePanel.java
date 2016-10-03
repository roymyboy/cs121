import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class TicTacToePanel extends JPanel
{

	private JRadioButton Dumb, Random;
	private JLabel winner;
	private JPanel buttonPanel;
	private Boolean win;
	private JButton label;
	private JButton[][] ticTacToeButtons;
	private int count = 0; 



	public TicTacToePanel()
	{ 
		setLayout(new BorderLayout());
		
		JPanel gridPanel = new JPanel(new GridLayout(3,3));
		JPanel boxPanel=new JPanel();
		
		label = new JButton ("New Game");
		
		winner=new JLabel("Wins: "+ count + " Losses: "+ count);

		Dumb=new JRadioButton("Dumb");
		Random=new JRadioButton("Random");
		
		ButtonGroup group = new ButtonGroup();
		group.add(Dumb);
		group.add(Random);
		
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(label);
		label.addActionListener(new ButtonListener());
		box.add(Dumb);
		box.add(Random);
		
		

		ticTacToeButtons = new JButton[3][3];
		GridLayout grid = new GridLayout(3,3);
		gridPanel.setLayout(grid);
		for (int i = 0; i < ticTacToeButtons.length; i++) 
		{
			for (int j = 0; j<ticTacToeButtons[i].length; j++)
			{
				ticTacToeButtons[i][j] = new JButton("");
				ticTacToeButtons[i][j].addActionListener(new ButtonListener());
				gridPanel.add(ticTacToeButtons[i][j]);
			}
		}
		
		  

		setBackground(Color.white);
		gridPanel.setPreferredSize(new Dimension(300, 300));

		
		
		add(box, BorderLayout.CENTER);
	
		add(winner, BorderLayout.SOUTH);
		
		add(gridPanel, BorderLayout.EAST);
	}
	
	private void dumbTurn()
	{
		for (int i = 0; i < ticTacToeButtons.length; i++) 
		{
			for (int j = 0; j<ticTacToeButtons[i].length; j++)
			{
				if (ticTacToeButtons[i][j].getText().equals(""))
				{
					ticTacToeButtons[i][j].setText("O");
					return;
				}
			}
		}
	}


	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JButton clicked = (JButton)e.getSource();
			
			if(clicked.getText().equals(""))
			{
				clicked.setText("X");
				dumbTurn();
			}
			
			//walk through each buttons and reser it to null
			if (e.getSource() == label)
			{
				for (int i = 0; i < ticTacToeButtons.length; i++) 
				{
					for (int j = 0; j < ticTacToeButtons.length; j++)
					ticTacToeButtons[i][j].setText("");
				}		
			}
		}	
	}
}
	
		

