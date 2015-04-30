
import java.util.*;

/**
 *
 */
public class AchiBehavior implements GameBehavior {

    int[][] legalMoves = {
        {1, 3, 4},
        {0, 2, 4},
        {1, 3, 5},
        {0, 4, 6},
        {0, 1, 2, 3, 5, 6, 7, 8},
        {2, 4, 8},
        {3, 4, 7},
        {6, 4, 8},
        {4, 5, 7}
    };

    public AchiBehavior() {
    }

    /**
     * @return
     */
    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        int position = 0;
        for (int i = 0; i < legalMoves[movesLeft.get(0)].length; i++) {
            if (myMoves.contains(legalMoves[movesLeft.get(0)][i])) {
                position = legalMoves[movesLeft.get(0)][i];
                i = legalMoves[movesLeft.get(0)].length;
            }
        }
        return position;
    }

}
