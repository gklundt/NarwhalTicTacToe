
import java.util.*;

/**
 *
 */
public class Engine extends GameEngine {

    /**
     *
     */
    ArrayList<Integer> enemyMoves;
    ArrayList<Integer> movesLeft;
    ArrayList<Integer> myMoves;

    public Engine() {
        gb = new RandomBehavior();
        enemyMoves = new ArrayList<>();
        movesLeft = new ArrayList<>();
        myMoves = new ArrayList<>();

    }

    /**
     * @param game
     * @return
     */
    @Override
    public int getMove(GameData game) {
        if (game.gameSequence.isEmpty()) {
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
        } else if (game.gameMode == GameMode.ACHI) {
            gb = new AchiBehavior();
            enemyMoves.add(game.gameSequence.getLast());
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
        } else {
            enemyMoves.add(game.gameSequence.getLast());
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
        }
        return myMoves.get(myMoves.size() - 1);
    }

}
