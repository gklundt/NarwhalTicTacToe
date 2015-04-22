
import java.util.*;

/**
 * 
 */
public class GameController extends AbstractGameController {

	private GameData gd;
	
    /**
     * 
     */
<<<<<<< HEAD
    public GameController(GameEngine ge, ProtocolAdapter pa) {
    	super(ge, pa);
    	gd = new GameData();
=======
    public GameController(GameEngine ge, AbstractProtocolAdapter pa) {
        super(ge, pa);
        
>>>>>>> master
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
    	pa.start(uri, gd);
    	control();
    }

    /**
     * @param uri 
     * @param code 
     * @return
     */
    public void start(String uri, String code) {
        gd.gameId = code;
    	pa.start(uri, gd);
    	control();
    }

    /**
     * 
     */
    private void control() {
        while (gd.result == Result.NONE) {
        	pa.getOpponentMove(gd);
        	notifyObservers();
        	ge.getMove(gd);
        	notifyObservers();
        }
    }

	@Override
	protected void notifyObservers() {
<<<<<<< HEAD
		for (GameObserver go : gameObservers) {
			go.update(gd);
		}
=======
		// TODO Auto-generated method stub
>>>>>>> master
		
	}

}