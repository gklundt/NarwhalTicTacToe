
import java.util.*;

/**
 * 
 */
public abstract class AbstractGameController {

    /**
     * 
     */
    protected ArrayList<GameObserver> gameObservers;

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
    public AbstractGameController(GameEngine ge, AbstractProtocolAdapter pa) {
        this.ge = ge;
        this.pa = pa;
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