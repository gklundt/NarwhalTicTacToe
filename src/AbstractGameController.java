
import java.util.ArrayList;


public abstract class AbstractGameController {

    protected ArrayList<GameObserver> gameObservers;
    protected GameEngine ge;
    protected AbstractProtocolAdapter pa;
	
    public AbstractGameController(GameEngine ge, AbstractProtocolAdapter pa) {
        this.ge = ge;
        this.pa = pa;
        
        gameObservers = new ArrayList<GameObserver>();
    }
	
    /**
     * @param obs
     */
    public abstract void subscribe(GameObserver obs );

    /**
     * 
     */
    protected abstract void notifyObservers();

    /**
     * @param uri
     */
    public abstract void start(String uri);

    /**
     * @param uri 
     * @param code
     */
    public abstract void start(String uri, String code);

}