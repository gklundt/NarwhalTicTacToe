
import java.util.*;

/**
 * 
 */
public abstract class AbstractProtocolAdapter  {

    /**
     * 
     */
    public AbstractProtocolAdapter() {
    }

    /**
     * 
     */
    protected String uri;

    /**
     * @param uri 
     * @param data
     */
    public abstract void start(String uri, GameData data);

    /**
     * @param data
     */
    public abstract void getOpponentMove(GameData data);

}