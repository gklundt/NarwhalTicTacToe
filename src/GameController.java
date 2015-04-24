
import java.util.*;

/**
 * 
 */
public class GameController extends AbstractGameController implements Runnable {

	private GameData gd;
	private Thread t;
	
    /**
     * 
     */
    public GameController(GameEngine ge, AbstractProtocolAdapter pa) {
    	super(ge, pa);
    }

    /**
     * @param obs
     */
    public void subscribe(GameObserver obs ) {
        gameObservers.add(obs);
    }

    /**
     * @param uri 
     * @return
     */
    public void start(String uri) {
    	gd = new GameData();
    	pa.start(uri, gd);
    	t = new Thread(this);
    	t.start();
    }

    /**
     * @param uri 
     * @param code 
     * @return
     */
    public void start(String uri, String code) {
    	gd = new GameData();
    	gd.gameId = code;
    	pa.start(uri, gd);
    	pa.start(uri, gd);
    	t = new Thread(this);
    	t.start();
    }

    /** This is the main game loop. Controls the flow of the game.
     *  implement the control method in the run() method. 
     */
    private void control() {
    	long prevTime;
        while (gd.result == Result.NONE) {
        	prevTime = System.currentTimeMillis();
        	
        	notifyObservers();							// Notify Observers first since GameData
        												// is changed in the start method.
        	
        	gd.gameSequence.add(ge.getMove(gd));		// Get move from the GameEngine and store
        	
        	gd.timeLeft = gd.timeLeft - (int) (System.currentTimeMillis() - prevTime);// the result in the GameData move history
        	notifyObservers();						
        												// and notifyObservers();
        	prevTime = System.currentTimeMillis();
        	pa.getOpponentMove(gd);						// Get the move from the opponent and
        	gd.timeLeft = gd.timeLeft - (int) (System.currentTimeMillis() - prevTime);											// return to the top of the loop to
        												// notifyObservers();
        }
        notifyObservers();
        gd = null;
    }

	@Override
	protected void notifyObservers() {
		for (GameObserver go : gameObservers) {
			go.update(gd);
		}
	}

	@Override
	public void run() {
		control();
	try {	
		t.join();
	}catch (InterruptedException e){
		  
	  }
	}

}