
import java.util.*;

/**
 * 
 */
public class GameController extends AbstractGameController {

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
    	control();
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
    	control();
    }

    /**
     * 
     */
    private void control() {
        while (gd.result == Result.NONE) {
        	notifyObservers();
        	gd.gameSequence.add(ge.getMove(gd));
        	notifyObservers();
        	pa.getOpponentMove(gd);
        }
        gd = null;
    }

	@Override
	protected void notifyObservers() {
		for (GameObserver go : gameObservers) {
			go.update(gd);
		}
		
		
		
	}

}