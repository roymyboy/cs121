import javax.swing.JFrame; 
import java.awt.Dimension;

public class MineWalker
{
	public static void main(String[] args)
	{
		JFrame f = new JFrame("MineWlaker");
		f.setPreferredSize(new Dimension(1000, 1000));
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MineWalkerPanel panel = new MineWalkerPanel();
		f.add(panel);
		
		f.pack();
		f.setVisible(true);
	}
}