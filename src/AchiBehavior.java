
import java.util.*;

/**
 *
 */
public class AchiBehavior implements GameBehavior {

    public AchiBehavior() {
    }

    /**
     * @param myMoves
     * @param enemyMoves
     * @return
     */
    @Override
    public int getMoveCommon(ArrayList myMoves, ArrayList enemyMoves) {
        int openMove = 0;
        while (myMoves.contains(openMove) && enemyMoves.contains(openMove)) {
            openMove++;
        }

        int nextMove = 0;

        while (nextMove < 9) {
            if (myMoves.contains(nextMove) && ((nextMove == openMove - 1) || (nextMove == openMove + 1))) {
                break;
            }
            nextMove++;
        }
        return nextMove;
    }

}
