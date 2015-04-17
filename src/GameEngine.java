
import java.util.*;

/**
 * 
 */
public abstract class GameEngine {

    /**
     * 
     */
    public GameEngine() {
    }

    /**
     * 
     */
    protected GameBehavior gb;


    /**
     * @param game 
     * @return
     */
    public abstract int getMove(GameData game);

}