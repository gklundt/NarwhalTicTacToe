
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
        int enemyLastMove = 0;
        int myNextMove = 0;
        if (game.gameSequence.isEmpty()) {
            //This block indicates first move of game.
            myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
            myMoves.add(Integer.valueOf(myNextMove));
            movesLeft.remove(Integer.valueOf(myNextMove));
        } else if (game.gameSequence.size() == 8) {
            //This block indicates first move of ACHI.
            gb = new AchiBehavior();
            enemyLastMove = game.gameSequence.getLast();
            enemyMoves.add(Integer.valueOf(enemyLastMove));
            movesLeft.remove(Integer.valueOf(enemyLastMove));
            myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
            myMoves.add(Integer.valueOf(myNextMove));
            movesLeft.set(0, Integer.valueOf(myNextMove));
        } else if (game.gameSequence.size() > 8) {
            //This block indicates full ACHI mode.
            gb = new AchiBehavior();
            enemyMoves.remove(Integer.valueOf(game.gameSequence.getLast()));
            enemyMoves.add(Integer.valueOf(movesLeft.get(movesLeft.size() - 1)));
            movesLeft.set(0, Integer.valueOf(game.gameSequence.getLast()));
            myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
            myMoves.remove(Integer.valueOf(myNextMove));
            myMoves.add(Integer.valueOf(movesLeft.get(movesLeft.size() - 1)));
            movesLeft.set(0, Integer.valueOf(myNextMove));
        } else {
            //This block indicates normal mode.
            enemyLastMove = game.gameSequence.getLast();
            enemyMoves.add(Integer.valueOf(enemyLastMove));
            movesLeft.remove(Integer.valueOf(enemyLastMove));
            myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
            myMoves.add(Integer.valueOf(myNextMove));
            movesLeft.remove(Integer.valueOf(myNextMove));
        }
        //Debugging code comment block
        /*System.out.print("Enemy Moves: ");
        enemyMoves.stream().forEach((enemyMove) -> {
            System.out.print(enemyMove + " ");
        });
        System.out.println();
        System.out.print("My Moves: ");
        for (Integer myMove : myMoves) {
            System.out.print(myMove + " ");
        }
        System.out.println();
        System.out.print("Moves Left: ");
        for (Integer myMove : movesLeft) {
            System.out.print(myMove + " ");
        }
        System.out.println();
        System.out.println("This Move: " + myMoves.get(myMoves.size() - 1));*/
        return myNextMove;
    }

}
