
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
        for (int i = 0; i < 9; i++) {
            movesLeft.add(i);
        }
    }

    /**
     * @param game
     * @return
     */
    @Override
    public int getMove(GameData game) {
        if (game.gameSequence.isEmpty()) {
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
            movesLeft.remove(myMoves.get(myMoves.size() - 1));
        } else if (game.gameSequence.size() == 8) {
            gb = new AchiBehavior();
            enemyMoves.add(game.gameSequence.getLast());
            movesLeft.remove(enemyMoves.get(enemyMoves.size() - 1));
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
            movesLeft.set(0, myMoves.get(myMoves.size() - 1));
        } else if (game.gameSequence.size() > 8) {
            gb = new AchiBehavior();
            movesLeft.set(0, game.gameSequence.getLast());
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
            movesLeft.set(0, myMoves.get(myMoves.size() - 1));
        } else {
            enemyMoves.add(game.gameSequence.getLast());
            movesLeft.remove(enemyMoves.get(enemyMoves.size() - 1));
            myMoves.add(gb.getMoveCommon(enemyMoves, movesLeft, myMoves));
            movesLeft.remove(myMoves.get(myMoves.size() - 1));
        }
        System.out.print("Enemy Moves: ");
        enemyMoves.stream().forEach((enemyMove) -> {
            System.out.print(enemyMove + " ");
        });
        System.out.println();
        System.out.print("My Moves: ");
        for (Integer myMove : myMoves) {
            System.out.print(myMove + " ");
        }
        System.out.println();
        System.out.println("This Move: " + myMoves.get(myMoves.size() - 1));
        //System.out.println(game.gameSequence.contains(myMoves.get(myMoves.size() - 1)));
        return myMoves.get(myMoves.size() - 1);
    }

}
