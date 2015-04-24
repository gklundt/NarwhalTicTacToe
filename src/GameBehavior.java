
import java.util.*;

/**
 * 
 */
public interface GameBehavior {


    /**
     * @param myMoves
     * @param enemyMoves
     * @return
     */
    public int getMoveCommon(ArrayList myMoves, ArrayList enemyMoves);

}