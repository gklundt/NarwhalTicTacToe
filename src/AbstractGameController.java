
import java.util.*;

/**
 * 
 */
public abstract class AbstractGameController {

    /**
     * 
     */
    public AbstractGameController() {
    }

    /**
     * 
     */
    protected Set<GameObserver> gameObservers;

    /**
     * 
     */
    protected GameEngine ge;

    /**
     * 
     */
    protected AbstractProtocolAdapter pa;




    /**
     * @param ge 
     * @param pa
     */
    public void AbstractGameController(GameEngine ge, AbstractProtocolAdapter pa) {
        // TODO implement here
    }

    /**
     * @param obs
     */
    public abstract void subscribe(GameObserver obs );

    /**
     * 
     */
    //protected abstract void notify();

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