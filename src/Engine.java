
import java.util.*;

/**
 * 
 */
public class Engine extends GameEngine {

    /**
     * 
     */
    public Engine() {
        gb = new GameEngineBehaviorRandom();
    }

    /**
     * @param game 
     * @return
     */
    @Override
    public int getMove(GameData game) {
        return gb.getMoveCommon(game);
    }

}