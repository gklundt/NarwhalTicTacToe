import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GameWindow extends JFrame implements GameObserver {

    private final AbstractGameController myGameController;
	private final ButtonListener btnObserver;
	public final JButton startGameBtn;
	public final JButton nextHistoryBtn;
	public final JButton prevHistoryBtn;
	private final JPanel cards;
	private final static String STARTGAMECARD = "Card for starting Game";
	private final static String PLAYGAMECARD = "Card for playing Game";
	private final JPanel startGamePanel;
	public final JTextField codeText;
	private final JLabel timeLeftLabel;
	private final JLabel whosTurnLabel;
	private final JLabel gameModeLabel;
	private final ArrayList<JButton> buttonList; 
	private final JPanel statsPanel;
	private final ArrayList<GameData>gameHistory;
	private int gameHistoryDepth;

    public GameWindow(AbstractGameController gc) {
		//observe any changes in myGameController
		this.myGameController = gc;
		gc.subscribe(this);

		buttonList = new ArrayList<>();
		gameHistory = new ArrayList<>();
		gameHistoryDepth =-1;
	
		Container rootWindow = getContentPane();
		//Use Card Layout
		//One card for setup
		JPanel startPageCard = new JPanel();
		//One card for gameplay
		JPanel playGameCard = new JPanel(new BorderLayout());
		cards = new JPanel(new CardLayout());
		JPanel buttonPanel = new JPanel(new GridLayout(3,3));
		statsPanel = new JPanel(new BorderLayout());
		JPanel gameModePanel = new JPanel();
		startGamePanel = new JPanel(new GridLayout(3, 1));
		JPanel gameHistoryButtonsPanel = new JPanel(new GridLayout(1,2));

		Font buttonFont = new Font("Courier New", Font.BOLD, 180);
		
		for (int i = 0; i < 9; i++) {
			JButton b = new JButton();
			b.setFont(buttonFont);
			buttonPanel.add(b);
			buttonList.add(b);
		}

		gameModeLabel = new JLabel("Movement Mode");
		timeLeftLabel = new JLabel("timeLeft");
		whosTurnLabel = new JLabel("Waiting on opponent...");
		JPanel statsLabelContainer = new JPanel(new GridLayout(4, 1)); 

		startGameBtn = new JButton("Start Game");
		btnObserver = new ButtonListener();
		startGameBtn.addActionListener(btnObserver);
		codeText = new JTextField("");
		prevHistoryBtn = new JButton("<");
		prevHistoryBtn.addActionListener(btnObserver);
		nextHistoryBtn = new JButton(">");
		nextHistoryBtn.addActionListener(btnObserver);

		//add components to containers
		gameHistoryButtonsPanel.add(prevHistoryBtn);
		gameHistoryButtonsPanel.add(nextHistoryBtn);
		startPageCard.add(startGamePanel);
		playGameCard.add(buttonPanel, "Center");
		statsLabelContainer.add(timeLeftLabel);
		statsLabelContainer.add(whosTurnLabel);
		statsLabelContainer.add(new JLabel("Game History"));
		statsLabelContainer.add(gameHistoryButtonsPanel);
		statsPanel.add(statsLabelContainer, "North");
		startGamePanel.add(startGameBtn/*2*/);
		startGamePanel.add(new JLabel("Game ID"));
		startGamePanel.add(codeText);
		playGameCard.add(statsPanel, "East");
		gameModePanel.add(gameModeLabel);
		playGameCard.add(gameModePanel, "South");
		cards.add(startPageCard, STARTGAMECARD);
		cards.add(playGameCard, PLAYGAMECARD);
		rootWindow.add(cards, BorderLayout.CENTER);


		//make start game button default button for enter
		JRootPane rootPane = SwingUtilities.getRootPane(startGameBtn);
		rootPane.setDefaultButton(startGameBtn);

		//JFrame setup
		this.setTitle("Narwal's Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(300, 300);
        this.setSize(600, 600);
		this.setVisible(true);
    }
	
	@Override
    public void update(GameData data ) {
		gameHistoryDepth++;
		gameHistory.add(data);
		this.updateBoard(data);
		this.updateTimeLeft(data);
		this.updateWhosTurn(data);
		this.updateGameMode(data);
		this.updateGameId(data);
    }

	private void updateBoard(GameData data) {
		//normal mode for first 8 moves
		//if we are first player use evens 0, 2, 4 indices in history for X's (or narwhals)
		//if we are second player use odds 1, 3, 5 indices in history for O's (or squids)

		//clear button text for update
		for(JButton b: buttonList){
			b.setText("");
		}

		if (!data.gameSequence.isEmpty()){

                Integer[] gs = data.gameSequence.toArray( new Integer[data.gameSequence.size()]);

            
			for(int i = 0;i < gs.length && i < 8; i++){
				for(int j=0; j < 9; j++){
					if(gs[i] == j){
						if(data.player.equals(Player.PLAYER1)){
							if((i % 2) == 0){
								buttonList.get(j).setText("X");
							}
							else {
								buttonList.get(j).setText("O");
							}
						}else{
							if((i % 2) == 0){
								buttonList.get(j).setText("O");
							}
							else {
								buttonList.get(j).setText("X");
							}
						}
					}
				}
			}
			//slide mode
			//slide history
			for(int i = 8; i < gs.length; i++){
				//board
				for(int j = 0; j < 9; j++){
					//if space is empty
					if(buttonList.get(j).getText().equals("")){
						//change button j to played indice i 
						buttonList.get(j).setText(buttonList.get(gs[i]).getText());
						//set where played indice i was to blank
						buttonList.get(gs[i]).setText("");
					}
				}
			}
		} else {
			System.out.println("empy deque");
		}
	}


	private void updateTimeLeft(GameData data) {
		int seconds = data.timeLeft / 1000;
		this.timeLeftLabel.setText(Integer.toString(seconds) + "s... Left");
	}

	//this method is not needed if the server tracks history
	private void updateWhosTurn(GameData data) {
		//waiting on opponent... or our turn (something went wrong)
		if(data.player.equals(Player.PLAYER1) && ((data.gameSequence.size() % 2)==0)){
			whosTurnLabel.setText("Your Turn");
		}else if(data.player.equals(Player.PLAYER2) && ((data.gameSequence.size() % 2)!=0)){
			whosTurnLabel.setText("Your Turn");
		}else{
			whosTurnLabel.setText("Waiting on Opponent...");
		}
		if(data.result == Result.LOSE){
			whosTurnLabel.setText("You Lose");
		}else if(data.result == Result.WIN){
			whosTurnLabel.setText("You Win");
		}
	}

	private void updateGameMode(GameData data) {
		if(data.result.equals(Result.NONE)){
			if(data.gameSequence.size() < 9){
				gameModeLabel.setText("Normal Mode");
			}
			else{
				gameModeLabel.setText("Achi Mode");
			}
		}
	}

	private void updateGameId(GameData data) {
		codeText.setText(data.gameId);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
		   JButton buttonPressed = (JButton) (ae.getSource());
			//switch to next card
			CardLayout c1 = (CardLayout)(cards.getLayout());
			c1.show(cards, PLAYGAMECARD);
			//move startGamePanel to second card
			statsPanel.add(startGamePanel, "South");
			//make start game button default button for enter
			JRootPane rootPane = SwingUtilities.getRootPane(startGameBtn);
			rootPane.setDefaultButton(startGameBtn);
			if(buttonPressed.equals(startGameBtn)){
				if(codeText.getText().equals("")){
					myGameController.start("");
					//myGameController.start();
				} else {
					myGameController.start("", codeText.getText());
					//myGameController.start();
				}
            Thread gameThread = new Thread(myGameController);
            gameThread.start();
			}
			if(buttonPressed.equals(prevHistoryBtn)){
				if(gameHistoryDepth > 1){
					gameHistoryDepth--;
					update(gameHistory.get(gameHistoryDepth));
				}
			}
			if(buttonPressed.equals(nextHistoryBtn)){
				if(gameHistoryDepth < gameHistory.size()){
					gameHistoryDepth++;
					update(gameHistory.get(gameHistoryDepth));
				}
			}
		}
	}
}
