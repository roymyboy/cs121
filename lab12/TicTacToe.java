import javax.swing.JFrame;

public class TicTacToe
{
	public static void main(String [] args)
	{
		JFrame f = new JFrame("Tic Tac Toe");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TicTacToePanel panel = new TicTacToePanel();
		f.add(panel);
		
		f.pack();
		f.setVisible(true);
	}
}