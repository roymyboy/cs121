import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Displays a grid of JButtons and a JTextArea. Together,
 * they act as a very small keyboard and text display.
 * This class manages layout of controls and also handles events.
 * 
 * @author mvail
 */
@SuppressWarnings("serial")
public class TextButtonsPanel extends JPanel implements ActionListener {
	private JButton[] buttons;	//Do not change
	private JTextArea textArea;	//Do not change
	//Assign values for these constants in the constructor
	private final int ENTER = 9;	//Index of Enter button in buttons
	private final int SPACE = 10;	//Index of Space button in buttons
	private final int CLEAR = 11;	//Index of Clear button in buttons
	

	/**
	 * Constructor
	 */
	public TextButtonsPanel() 
	{
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(4, 3));
		gridPanel.setPreferredSize(new Dimension(320, 220));
		
		textArea = new JTextArea(80,120);
		textArea.setEditable(false);
		 
		JScrollPane scrollPane = new JScrollPane(textArea,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setPreferredSize(new Dimension(100, 220));
		//TODO: Create and populate the buttons array
		
		buttons = new JButton[12];
		buttons [0] = new JButton("A");
		buttons [1] = new JButton("B");
		buttons [2] = new JButton("C");
		buttons [3] = new JButton("1");
		buttons [4] = new JButton("2");
		buttons [5] = new JButton("3");
		buttons [6] = new JButton("X");
		buttons [7] = new JButton("Y");
		buttons [8] = new JButton("Z");
		buttons [ENTER] = new JButton("ENTER");
		buttons [SPACE] = new JButton("SPACE");
		buttons [CLEAR] = new JButton("CLEAR");
		//TODO: Register this as the listener for all buttons
		//TODO: Create the text area - set its editable property to false


		//TODO: Create a sub-panel with a 4 row, 3 column GridLayout
		//TODO: Populate the grid with buttons
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setBackground(Color.white);
			buttons[i].addActionListener(this);
			gridPanel.add(buttons[i]);
		}
		
		//TODO: Add the grid panel to this panel
		

		//TODO: Create a JScrollPane containing textArea
		
		//TODO: Set the preferred size of the scroll pane to at least 80x120
		//TODO: Add the scroll pane to this panel
		this.add(mainPanel);
		mainPanel.add(gridPanel);
		mainPanel.add(scrollPane);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO update the contents of textArea according to which
		//  button generated the ActionEvent.
		JButton clicked = (JButton)e.getSource();
		
		if (clicked == buttons[ENTER] )
		{
			textArea.append("\n");
		} 
		else if (clicked == buttons[SPACE])
		{
			textArea.append(" ");
		}
		else if (clicked == buttons[CLEAR])
		{
			textArea.setText("");
		}else 
		{
			textArea.append(clicked.getText());
		}
		
	}
}
