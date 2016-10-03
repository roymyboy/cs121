import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;

public class MineWalkerPanel extends JPanel implements ActionListener
{
	private JButton[][] mineWalkerButtons;
	private JButton mineShow;
	private JButton showPath;
	private JButton reStart;
	private JPanel rightPanel;
	private JPanel topPanel;
	private JPanel gridPanel;
	private JPanel colorPanel;
	private JPanel controlPanel;
	private JLabel life = new JLabel(); 
	private JLabel lLabel, colors[];
	private JLabel sLabel;	
	private JSlider difficulty;
	private int diff= 25;
	private int score = 0;
	private int lives = 0;
	private int gridDimension = 10;
	private int newDimension= 10;
	private int points = 5;
	private int	mineCount;
	private int percentMine = 4;
	private int DELAY = 5;
	private JTextField textSize;
	private RandomWalk safeWalk;
	private ArrayList<Point> path;
	private ArrayList<Point> mines;
	private ArrayList<Point> fwd;
	private boolean exist = false;
	private Timer t;
	private Point local = new Point(gridDimension-1, gridDimension- 1) ;
	Color [] bColors = {Color.green, Color.yellow, Color.orange, Color.red, Color.black, Color.gray, Color.cyan };
	String [] labels = {"O nearby Mines", "1 nearby Mines", "2 nearby Mines", "3 nearby Mines", "Exploded mine", "'X' local Position", 						"Destination"};

	public MineWalkerPanel()
	{
		newGame();
		generateMines();
		setLayout(new BorderLayout());

		//adds a new panel on top bottom and right side
		rightPanel = new JPanel();
		topPanel = new JPanel();
		colorPanel = new JPanel();

		//Start a new game
		reStart = new JButton("New Game");
		reStart.addActionListener(this);

		//shows all the mines in the gridpanel
		mineShow = new JButton("Show Mine");
		mineShow.addActionListener(this);

		//shows all the available path from start to end
		showPath = new JButton("Show Path");
		showPath.addActionListener(this);

		//score and life tracker
		sLabel = new JLabel("Score:   ");
		lLabel = new JLabel("Life:  ");

		//adding life and score to the topPanel
		topPanel.add(sLabel);
		topPanel.add(lLabel);

		//reset 
		//gridSize.setEditable(true);
		textSize = new JTextField(10);
		textSize.setText(Integer.toString(gridDimension));
		textSize.addActionListener(this);
		controlPanel = new JPanel();
		textSize.setEditable(true);

		difficulty = new JSlider(JSlider.HORIZONTAL, 5, 10, 10);
		controlPanel.add(difficulty);
		difficulty.setBorder(BorderFactory.createTitledBorder("Difficulty Level"));
		difficulty.setMaximum(4);
		difficulty.setMinimum(1);
		difficulty.setMajorTickSpacing(1);
		difficulty.setPaintTicks(true);
		difficulty.setPaintLabels(true);
		SliderListener listener = new SliderListener();
		difficulty.addChangeListener(listener);

		//this.add(gridPanel);

		//bottom keys 
		controlPanel.add(textSize);
		controlPanel.add(reStart);
		controlPanel.add(mineShow);
		controlPanel.add(showPath);

		//top panel
		topPanel.setPreferredSize(new Dimension(20, 20));
		topPanel.setToolTipText("Score: ");

		//adding dimension
		rightPanel.setPreferredSize(new Dimension(250, 250));
		colorPanel.setBorder(BorderFactory.createTitledBorder("Keys"));
		colorPanel.setPreferredSize(new Dimension(150, 250));
		colorPanel.setLayout(new GridLayout(8, 1));

		//Button you
		JButton youLabel = new JButton();
		JLabel rightLabel7 = new JLabel("X <- You");
		youLabel.add(rightLabel7);
		colors = new JLabel[9];

		for (int a = 0; a<labels.length; a++)
		{
			colors[a] = new JLabel(labels[a]);
			colors[a].setOpaque(true);
			colors[a].setBackground(bColors[a]);
			colorPanel.add(colors[a]);
		}
		colorPanel.add(youLabel);

		//creating mine walker buttons
		gridPanel = new JPanel(new GridLayout(gridDimension,gridDimension));
		mineWalkerButtons = new JButton[gridDimension][gridDimension];
		GridLayout grid = new GridLayout(gridDimension, gridDimension);
		gridPanel.setLayout(grid);

		for (int i = 0; i < mineWalkerButtons.length; i++) 
		{
			for (int j = 0; j<mineWalkerButtons[i].length; j++)
			{
				mineWalkerButtons[i][j] = new JButton("");
				mineWalkerButtons[i][j].addActionListener(this);
				gridPanel.add(mineWalkerButtons[i][j]);
			}
		}
		mineWalkerButtons[gridDimension-1][gridDimension-1].setBackground(Color.GREEN);
		mineWalkerButtons[0][0].setBackground(Color.cyan);

		//adding the panels to the JFrame
		add(topPanel, BorderLayout.NORTH);

		rightPanel.add(colorPanel, BorderLayout.CENTER);
		add(rightPanel, BorderLayout.EAST);

		textSize.setBorder(BorderFactory.createTitledBorder("Grid Size"));

		add(controlPanel, BorderLayout.SOUTH);
		add(gridPanel, BorderLayout.CENTER);



	}
	private class SliderListener implements ChangeListener {

		public void stateChanged(ChangeEvent event) {
			diff = difficulty.getValue();
		}
	}
	private class TimerActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent evt)
		{
                        // toggle color/text for current tile
		        // do other periodic checks if needed
		}
	}

       /**
        * Create an animation thread that runs periodically
        */
        private void startAnimation()
        {
    	    TimerActionListener taskPerformer = new TimerActionListener();
    	    new Timer(DELAY, taskPerformer).start();
        }

	private void newGame()
	{
		safeWalk = new RandomWalk(gridDimension);
		safeWalk.createWalk();
		path = safeWalk.getPath();

	}

	private void reUpdate()
	{	
		this.remove(gridPanel);
		revalidate();


		try
		{
			gridDimension = Integer.parseInt(textSize.getText().trim());
			if (gridDimension < 1) { // invalid dimension
				// reset gridDim and text field to previous values
				gridDimension = newDimension;
				textSize.setText(Integer.toString(gridDimension));
			}
		}catch(Exception e)
		{
			gridDimension = newDimension;
			textSize.setText(Integer.toString(gridDimension));
		}

		newGame();
		generateMines();
		colorCode();
		gridPanel = new JPanel(new GridLayout(gridDimension,gridDimension));
		mineWalkerButtons = new JButton[gridDimension][gridDimension];
		GridLayout grid = new GridLayout(gridDimension, gridDimension);
		gridPanel.setLayout(grid);

		for (int i = 0; i < mineWalkerButtons.length; i++) 
		{
			for (int j = 0; j<mineWalkerButtons[i].length; j++)
			{
				mineWalkerButtons[i][j] = new JButton("");
				mineWalkerButtons[i][j].addActionListener(this);
				gridPanel.add(mineWalkerButtons[i][j]);
			}
		}
		add(gridPanel, BorderLayout.CENTER);
		mineWalkerButtons[0][0].setBackground(Color.cyan);
		mineWalkerButtons[gridDimension-1][gridDimension-1].setBackground(Color.GREEN);



	}


	private void generateMines()
	{
		mines = new ArrayList<Point>();
		Random rnd = new Random(); 
		for (int a = 0; a < (gridDimension*gridDimension-path.size())/4; a++)
		{
			int rndx = rnd.nextInt(gridDimension);
			int rndy = rnd.nextInt(gridDimension);
			Point temp = new Point(rndx,rndy);
			while(path.contains(temp) || mines.contains(temp)){
				rndx = rnd.nextInt(gridDimension);
				rndy = rnd.nextInt(gridDimension);
				temp = new Point(rndx,rndy);
			}
			mines.add(temp);

		}

	}

	private void showMessageLose(){
		if (points == 0) {
			JOptionPane.showMessageDialog(null, "You Lose", "You Lose", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void showMessageWin(){


		if (local.x == 0 && local.y == 0) {
			JOptionPane.showMessageDialog(null, "You win", "You win", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	private void looser()
	{
		if (points == 0) 
		{

			for (int i = 0; i < mineWalkerButtons.length; i++) 
			{
				for (int j = 0; j < mineWalkerButtons.length; j++) 
				{
					if (mines.contains(new Point(i, j))) 
					{
						mineWalkerButtons[i][j].setBackground(Color.BLACK);

					}
				}
			}
			showMessageLose();
		}

	}

	//set up the path

	private boolean movement (Point P){

		if (P.x == local.x+1 && P.y ==local.y){
			exist = true;
		}
		else if(P.x == local.x-1 && P.y == local.y){
			exist = true;

		}

		else if(P.x == local.x && P.y == local.y+1){
			exist = true;
		}
		else if(P.x == local.x && P.y == local.y-1){
			exist = true;
		}
		else{
			exist = false;
		}
		return exist;
	}

	public void colorCode()
	{
		for (int i = 0; i < mineWalkerButtons.length; i++) {
			for (int col = 0; col < mineWalkerButtons.length; col++) {

				// east
				if (mines.contains(new Point(local.x + 1, local.y))) {
					if (mines.contains(new Point(local.x - 1, local.y))
							&& mines.contains(new Point(local.x,
									local.y - 1))
									|| // east,west,north
									mines.contains(new Point(local.x - 1, local.y))
									&& mines.contains(new Point(local.x,
											local.y + 1))
											|| // east,west,south
											mines.contains(new Point(local.x, local.y + 1))
											&& mines.contains(new Point(local.x,
													local.y - 1))) // east,south,north
					{
						mineWalkerButtons[local.x][local.y].setBackground(Color.RED);
					} else if (mines.contains(new Point(local.x - 1,
							local.y))
							|| // east, west
							mines.contains(new Point(local.x, local.y + 1))
							|| // east,south
							mines.contains(new Point(local.x, local.y - 1))) { // east,north
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.ORANGE);
					} else {
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.YELLOW); // east
					}
				}
				// west
				if (mines.contains(new Point(local.x - 1, local.y))) {
					if (mines.contains(new Point(local.x, local.y - 1))
							&& mines.contains(new Point(local.x + 1,
									local.y))
									|| // west,north, east
									mines.contains(new Point(local.x, local.y + 1))
									&& mines.contains(new Point(local.x + 1,
											local.y))
											|| // west, south, and east
											mines.contains(new Point(local.x, local.y - 1))
											&& mines.contains(new Point(local.x,
													local.y + 1)))// west,north,south
					{
						mineWalkerButtons[local.x][local.y].setBackground(Color.RED);

					} else if (mines.contains(new Point(local.x + 1,
							local.y))
							|| // west,east
							mines.contains(new Point(local.x, local.y + 1))
							|| // south, west
							mines.contains(new Point(local.x, local.y - 1))) { // north,
						// west
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.ORANGE);

					} else {
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.YELLOW); // west
					}
				}
				// north
				if (mines.contains(new Point(local.x, local.y - 1))) {
					if (mines.contains(new Point(local.x + 1, local.y))
							&& mines.contains(new Point(local.x - 1, local.y))

							|| // N,E,W
							mines.contains(new Point(local.x, local.y + 1))
							&& mines.contains(new Point(local.x - 1,
									local.y))
									|| // N,S,E
									mines.contains(new Point(local.x - 1, local.y))
									&& mines.contains(new Point(local.x,
											local.y + 1)))// N,W,S
					{
						mineWalkerButtons[local.x][local.y].setBackground(Color.RED);

					} else if (mines.contains(new Point(local.x + 1,
							local.y))
							|| // N,E
							mines.contains(new Point(local.x - 1, local.y))
							|| // N,W
							mines.contains(new Point(local.x, local.y + 1))) { // N,S
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.ORANGE);

					} else {
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.YELLOW); // north
					}
				}
				// south
				if (mines.contains(new Point(local.x, local.y + 1))) {
					if (mines.contains(new Point(local.x + 1, local.y))
							&& mines.contains(new Point(local.x - 1,
									local.y))
									|| // S,E,W
									mines.contains(new Point(local.x, local.y - 1))
									&& mines.contains(new Point(local.x + 1,
											local.y))
											|| // S,N,E
											mines.contains(new Point(local.x, local.y - 1))
											&& mines.contains(new Point(local.x - 1,
													local.y)))// S,N,W
					{
						mineWalkerButtons[local.x][local.y].setBackground(Color.RED);

					} else if (mines.contains(new Point(local.x + 1,
							local.y))
							|| // S,E
							mines.contains(new Point(local.x - 1, local.y))
							|| // S,W
							mines.contains(new Point(local.x, local.y - 1))) { // S,N
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.ORANGE);

					} else {
						mineWalkerButtons[local.x][local.y]
								.setBackground(Color.YELLOW); // south
					}

				}

			}

		}
	}
	//setupSlider
	public void stateChanged(ChangeEvent arg0) 
	{

		if (difficulty.getValue() == 4) {
			percentMine = 1;
		} else if (difficulty.getValue() == 2) {
			percentMine = 3;
		} else if (difficulty.getValue() == 3) {
			percentMine = 2;
		} else if (difficulty.getValue() == 1) {
			percentMine = 9;
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == reStart) {
			//playSound("rays.wav");
			if (reStart.getText().equals("New Game")) {
				reUpdate();
				local = new Point(gridDimension-1, gridDimension-1);
				lLabel.setText("Lives: " + points); 
				sLabel.setText("   Score:  " + score);

				reStart.setText("Give up");
				// enable the controls
				difficulty.setEnabled(true);
				textSize.setEnabled(true);

				mineShow.setText("Show Mine");
				showPath.setText("Show Path");

			} else {
				// Cancel game
				reStart.setText("New Game");
				mineShow.setText("Show Mine");
				showPath.setText("Show Path");
				reUpdate();
				colorCode();
				// enable the controls
				difficulty.setEnabled(true);
				mineShow.setEnabled(true);
				showPath.setEnabled(true);
				textSize.setEnabled(true);
			}

		}


		// Show Mines
		else if (e.getSource() == mineShow) {
			//playSound("picture.wav");
			if (mineShow.getText().equals("Show Mine")) {

				for (int i = 0; i < mineWalkerButtons.length; i++)
					for (int j = 0; j < mineWalkerButtons.length; j++){
						if(mines.contains(new Point(i,j)))
							mineWalkerButtons[i][j].setBackground(Color.BLACK);
					}
				mineShow.setText("Hide Mine");

			} else {
				// hide mines
				for (int i = 0; i < mineWalkerButtons.length; i++)
					for (int j = 0; j < mineWalkerButtons.length; j++){
						if(mines.contains(new Point(i,j)))
							mineWalkerButtons[i][j].setBackground(null);
					}
				mineShow.setText("Show Mine");

			}
		}
		// show path
		else if (e.getSource() == showPath) {
			//playSound("plop.wav");
			if (showPath.getText().equals("Show Path")) {

				showPath.setText("Hide Path");
				for (int i = 0; i < safeWalk.path.size(); i++) {
					mineWalkerButtons[path.get(i).x][path.get(i).y].setBackground(Color.GREEN);
				}

			} else {
				// hide path
				showPath.setText("Show Path");

				for (int i = 0; i < safeWalk.path.size(); i++) {
					/* Call the getters here. */
					mineWalkerButtons[path.get(i).x][path.get(i).y].setBackground(null);
					mineWalkerButtons[0][0].setBackground(Color.cyan);
					mineWalkerButtons[gridDimension-1][gridDimension-1].setBackground(Color.GREEN);
				}
			}
		}



		// cancel game
		for (int i = 0; i < mineWalkerButtons.length; i++) {
			for (int j = 0; j < mineWalkerButtons[i].length; j++) {
				if (e.getSource().equals(mineWalkerButtons[i][j])) {
					if (movement(new Point(i, j))) {

						if (mines.contains(new Point(i, j))) {
							mineWalkerButtons[i][j]
									.setBackground(Color.BLACK);
							lLabel.setText("Lives" + --points);
							if(points == 0){
								looser();
							}
						}

						else {
							colorCode();

							local = new Point(i, j);
							colorCode();
							mineWalkerButtons[i][j].setText("X");
							mineWalkerButtons[i][j]
									.setBackground(Color.GREEN);

							colorCode();
							sLabel.setText("Score:" + ++score);
							colorCode();

							if (local.x == 0 && local.y == 0) {
								//showMessageDialogWin(local);
								showMessageWin();
							}

						}

					}
				}

			}

		}
	}

}

