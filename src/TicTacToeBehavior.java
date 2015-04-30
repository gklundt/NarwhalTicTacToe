
import java.util.*;

/**
 *
 */
public class TicTacToeBehavior implements GameBehavior {

    int move;
    int[] sidePositions = {1, 3, 5, 7};
    int[] cornerPositions = {0, 2, 6, 8};

    public TicTacToeBehavior() {
        move = 1;
    }

    private boolean detectCornerMove() {
        for (int i = 0; i < cornerPositions.length; i++) {
            if (cornerPositions[i] == move) {
                return true;
            }
        }
        return false;
    }

    private boolean detectSideMove(int move) {
        for (int i = 0; i < sidePositions.length; i++) {
            if (sidePositions[i] == move) {
                return true;
            }
        }
        return false;
    }

    private int getBlockMove() {
        return 0;
    }

    /**
     * @return
     */
    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        int myNextMove = 0;
        if (enemyMoves.isEmpty()) {
            myNextMove = 4;
        } else {
            switch (move) {
                case 2:
                    if (enemyMoves.contains(4)) {
                        myNextMove = 0;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        }
        move++;
        return myNextMove;
    }

}
