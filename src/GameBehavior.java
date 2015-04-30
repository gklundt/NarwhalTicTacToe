
import java.util.*;

/**
 * 
 */
public interface GameBehavior {


    /**
     * @param enemyMoves
     * @param movesLeft
     * @param myMoves 
     * @return
     */
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves);

}