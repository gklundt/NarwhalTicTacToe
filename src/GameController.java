
import java.util.*;

/**
 * 
 */
public class GameController extends AbstractGameController implements Runnable {

	private GameData gd;
	
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
    	//control();
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
    	//control();
    }

    /** This is the main game loop. Controls the flow of the game.
     *  implement the control method in the run() method. 
     */
    private void control() {
        while (gd.result == Result.NONE) {
        	notifyObservers();							// Notify Observers first since GameData
        												// is changed in the start method.
        	
        	gd.gameSequence.add(ge.getMove(gd));		// Get move from the GameEngine and store
        												// the result in the GameData move history
        	notifyObservers();							// and notifyObservers();
        	
        	pa.getOpponentMove(gd);						// Get the move from the opponent and
        												// return to the top of the loop to
        												// notifyObservers();
        }
        	
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
	}

}