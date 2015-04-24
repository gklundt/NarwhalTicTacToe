
import java.util.*;

/**
 *
 */
public class Engine extends GameEngine {

    private final ArrayList<Integer> enemyMoves;
    private final ArrayList<Integer> myMoves;

    public Engine() {
        enemyMoves = new ArrayList<>();
        myMoves = new ArrayList<>();
        gb = new GameEngineBehaviorRandom();
    }

    /**
     * @param game
     * @return
     */
    @Override
    public int getMove(GameData game) {
        if(game.gameMode == game.gameMode.ACHI) {
            gb = new AchiBehavior();
        }
        enemyMoves.add(game.gameSequence.getLast());
        myMoves.add(gb.getMoveCommon(myMoves, enemyMoves));
        return myMoves.get(myMoves.size() - 1);
    }

}
