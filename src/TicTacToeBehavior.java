
import java.util.*;

/**
 *
 */
public class TicTacToeBehavior implements GameBehavior {

    int[] sidePositions = {1, 3, 5, 7};
    int[] cornerPositions = {0, 2, 6, 8};
    int[][] winningPositions = {
        {0, 1, 2},
        {3, 4, 5},
        {6, 7, 8},
        {0, 4, 8},
        {2, 4, 6},
        {0, 3, 6},
        {1, 4, 7},
        {2, 5, 8}
    };

    public TicTacToeBehavior() {
    }

    private boolean detectCornerMove(int move) {
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

    private int detectBlock(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft) {
        int positions;
        int blockThisPosition = 0;
        for (int i = 0; i < 8; i++) {
            positions = 0;
            for (int j = 0; j < 3; j++) {
                if (enemyMoves.contains(Integer.valueOf(winningPositions[i][j]))) {
                    positions++;
                } else {
                    if (movesLeft.contains(Integer.valueOf(winningPositions[i][j]))) {
                        blockThisPosition = winningPositions[i][j];
                    } else {
                        positions = 0;
                    }
                }
            }
            if (positions >= 2) {
                return blockThisPosition;
            }
        }
        return -1;
    }

    private int detectWin(ArrayList<Integer> myMoves, ArrayList<Integer> movesLeft) {
        int positions;
        int winThisPosition = 0;
        for (int i = 0; i < 8; i++) {
            positions = 0;
            for (int j = 0; j < 3; j++) {
                if (myMoves.contains(Integer.valueOf(winningPositions[i][j]))) {
                    positions++;
                } else {
                    if (movesLeft.contains(Integer.valueOf(winningPositions[i][j]))) {
                        winThisPosition = winningPositions[i][j];
                    } else {
                        positions = 0;
                    }
                }
            }
            if (positions >= 2) {
                return winThisPosition;
            }
        }
        return -1;
    }

    /**
     * @return
     */
    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        int myNextMove = movesLeft.get(0);
        System.out.println("m: " + movesLeft.size());
        switch (9 - movesLeft.size()) {
            case 0:
                //Player 1 move 1
                myNextMove = 4;
                break;
            case 1:
                //Player 2 move 1
                if (enemyMoves.contains(Integer.valueOf(4))) {
                    myNextMove = 1;
                } else {
                    myNextMove = 4;
                }
                break;
            case 2:
                //Player 1 move 2
                if (detectCornerMove(enemyMoves.get(enemyMoves.size() - 1))) {
                    for (int i = 0; i < cornerPositions.length; i++) {
                        myNextMove = cornerPositions[i];
                        if (!enemyMoves.contains(Integer.valueOf(myNextMove))) {
                            i = cornerPositions.length;
                        }
                    }
                } else if (detectSideMove(enemyMoves.get(enemyMoves.size() - 1))) {
                    for (int i = 0; i < sidePositions.length; i++) {
                        myNextMove = sidePositions[i];
                        if (!enemyMoves.contains(Integer.valueOf(myNextMove))) {
                            i = sidePositions.length;
                        }
                    }
                }
                break;
            case 3:
                if (detectBlock(enemyMoves, movesLeft) > -1) {
                    myNextMove = detectBlock(enemyMoves, movesLeft);
                } else if (detectWin(myMoves, movesLeft) > - 1) {
                    myNextMove = detectWin(myMoves, movesLeft);
                } else {
                    myNextMove = movesLeft.get(movesLeft.size() - 1);
                }
                break;
            case 4:
                if (detectBlock(enemyMoves, movesLeft) > -1) {
                    myNextMove = detectBlock(enemyMoves, movesLeft);
                } else if (detectWin(myMoves, movesLeft) > -1) {
                    myNextMove = detectWin(myMoves, movesLeft);
                } else {
                    myNextMove = movesLeft.get(movesLeft.size() - 1);
                }
                break;
            case 5:
                if (detectBlock(enemyMoves, movesLeft) > -1) {
                    myNextMove = detectBlock(enemyMoves, movesLeft);
                } else if (detectWin(myMoves, movesLeft) > -1) {
                    myNextMove = detectWin(myMoves, movesLeft);
                } else {
                    myNextMove = movesLeft.get(movesLeft.size() - 1);
                }
                break;
            case 6:
                if (detectBlock(enemyMoves, movesLeft) > -1) {
                    myNextMove = detectBlock(enemyMoves, movesLeft);
                } else if (detectWin(myMoves, movesLeft) > -1) {
                    myNextMove = detectWin(myMoves, movesLeft);
                } else {
                    myNextMove = movesLeft.get(movesLeft.size() - 1);
                }
                break;
            case 7:
                if (detectBlock(enemyMoves, movesLeft) > -1) {
                    myNextMove = detectBlock(enemyMoves, movesLeft);
                } else if (detectWin(myMoves, movesLeft) > -1) {
                    myNextMove = detectWin(myMoves, movesLeft);
                } else {
                    myNextMove = movesLeft.get(movesLeft.size() - 1);
                }
                break;
            default:
                break;
        }
        return myNextMove;
    }

}
