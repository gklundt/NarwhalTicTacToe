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
	private final JButton startGameBtn;
	private final JPanel cards;
	private final static String STARTGAMECARD = "Card for starting Game";
	private final static String PLAYGAMECARD = "Card for playing Game";
	private final JButton startGameBtn2;
	private final JPanel startGamePanel;
	private final JTextField codeText;
	private final JTextField codeText2;
	private final JLabel timeLeftLabel;
	private final JLabel whosTurnLabel;
	private final JLabel gameModeLabel;
	private final ArrayList buttonList; 
	private final JPanel statsPanel;

    public GameWindow(AbstractGameController gc) {
		//observe any changes in myGameController
		this.myGameController = gc;
		gc.subscribe(this);

		buttonList = new ArrayList<>();
	
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
		JPanel statsLabelContainer = new JPanel(new GridLayout(2, 1)); 

		startGameBtn = new JButton("Start Game");
		startGameBtn2 = new JButton("Start Game");
		btnObserver = new ButtonListener();
		startGameBtn.addActionListener(btnObserver);
		startGameBtn2.addActionListener(btnObserver);

		JPanel codePanel = new JPanel(new GridLayout(2, 1));
		codeText = new JTextField("");
		codeText2 = new JTextField();
		codePanel.add(new JLabel("Game ID"));
		codePanel.add(codeText);

		//add components to containers
		startPageCard.add(startGamePanel);
		playGameCard.add(buttonPanel, "Center");
		statsLabelContainer.add(timeLeftLabel);
		statsLabelContainer.add(whosTurnLabel);
		statsPanel.add(statsLabelContainer, "North");
		startGamePanel.add(startGameBtn/*2*/);
		startGamePanel.add(new JLabel("Game ID"));
		startGamePanel.add(codeText2);
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
        this.setSize(500, 500);
		this.setVisible(true);
    }
	
	private void startGame(){
	}
	
	@Override
    public void update(GameData data ) {
		this.updateBoard(data);
		this.updateTimeLeft(data);
		//this.updateWhosTurn(data);
		this.updateGameMode(data);
    }

	private void updateBoard(GameData data) {
		//if we are first player use evens 0, 2, 4 indices in history for X's (or narwhals)

		//if we are second player use odds 1, 3, 5 indices in history for O's (or squids)
		
	}


	private void updateTimeLeft(GameData data) {
		int seconds = data.timeLeft / 1000;
		this.timeLeftLabel.setText(Integer.toString(seconds) + "s... Left");
	}

	//this method is not needed if the server tracks history
	private void updateWhosTurn() {
		//waiting on opponent... or our turn (something went wrong)
	}

	private void updateGameMode(GameData data) {
		if(data.gameMode.equals(GameMode.ACHI)){
			gameModeLabel.setText("Achi Mode");
		}
		else{
			gameModeLabel.setText("Slide Mode");
		}
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent ae) {
		   JButton buttonPressed = (JButton) (ae.getSource());
			if(buttonPressed.equals(startGameBtn)){
				if(codeText.getText().equals("")){
					//myGameController.start();
				} else {
					//myGameController.start(codeText gameID)
				}

				statsPanel.add(startGamePanel, "South");

				//make start game button default button for enter
				JRootPane rootPane = SwingUtilities.getRootPane(startGameBtn);
				rootPane.setDefaultButton(startGameBtn);

				//switch to next card
				CardLayout c1 = (CardLayout)(cards.getLayout());
				c1.show(cards, PLAYGAMECARD);
			}     
		}

	}
	
}