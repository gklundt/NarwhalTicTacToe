
import java.util.*;

/**
 *
 */
public class Engine extends GameEngine {

    /**
     *
     */
    private ArrayList<Integer> enemyMoves;
    private ArrayList<Integer> movesLeft;
    private ArrayList<Integer> myMoves;
    private boolean iAmFirstPlayer;

    public Engine() {
        //gb = new RandomBehavior();
        gb = new TicTacToeBehavior();
        enemyMoves = new ArrayList<>();
        movesLeft = new ArrayList<>();
        myMoves = new ArrayList<>();
        iAmFirstPlayer = false;
        for (int i = 0; i < 9; i++) {
            movesLeft.add(Integer.valueOf(i));
        }
    }

    /**
     * @param game
     * @return
     */
    @Override
    public int getMove(GameData game) {
        ArrayList<Integer> gameArray = new ArrayList<>();
        int enemyLastMove = 0;
        int myNextMove = 0;
        enemyMoves = new ArrayList<>();
        movesLeft = new ArrayList<>();
        myMoves = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            movesLeft.add(Integer.valueOf(i));
        }
        if (game.gameSequence.isEmpty()) {
            iAmFirstPlayer = true;
        }

        while (!game.gameSequence.isEmpty()) {
            gameArray.add(Integer.valueOf(game.gameSequence.getFirst()));
            game.gameSequence.removeFirst();
        }

        for (int i = 0; i < gameArray.size(); i++) {
            game.gameSequence.add(gameArray.get(i));
        }
        if (iAmFirstPlayer && gameArray.size() < 9) {
            for (int i = 0; i < gameArray.size(); i++) {
                if (i == 0 || i % 2 == 0) {
                    myMoves.add(Integer.valueOf(gameArray.get(i)));
                } else {
                    enemyMoves.add(Integer.valueOf(gameArray.get(i)));
                }
                movesLeft.remove(Integer.valueOf(gameArray.get(i)));
            }
        } else if (!iAmFirstPlayer && gameArray.size() < 9) {
            for (int i = 0; i < gameArray.size(); i++) {
                if (i == 0 || i % 2 == 0) {
                    enemyMoves.add(Integer.valueOf(gameArray.get(i)));
                } else {
                    myMoves.add(Integer.valueOf(gameArray.get(i)));
                }
                movesLeft.remove(Integer.valueOf(gameArray.get(i)));
            }
        } else if (iAmFirstPlayer && gameArray.size() > 8) {
            for (int i = 0; i < 8; i++) {
                if (i == 0 || i % 2 == 0) {
                    myMoves.add(Integer.valueOf(gameArray.get(i)));
                } else {
                    enemyMoves.add(Integer.valueOf(gameArray.get(i)));
                }
                movesLeft.remove(Integer.valueOf(gameArray.get(i)));
            }
            for (int i = 8; i < gameArray.size(); i++) {
                if (i % 2 == 0) {
                    myMoves.remove(Integer.valueOf(gameArray.get(i)));
                    myMoves.add(Integer.valueOf(movesLeft.get(0)));
                    movesLeft.set(0, Integer.valueOf(gameArray.get(i)));
                } else {
                    enemyMoves.remove(Integer.valueOf(gameArray.get(i)));
                    enemyMoves.add(Integer.valueOf(movesLeft.get(0)));
                    movesLeft.set(0, Integer.valueOf(gameArray.get(i)));
                }
            }
        } else if (!iAmFirstPlayer && gameArray.size() > 8) {
            for (int i = 0; i < 8; i++) {
                if (i == 0 || i % 2 == 0) {
                    enemyMoves.add(Integer.valueOf(gameArray.get(i)));
                } else {
                    myMoves.add(Integer.valueOf(gameArray.get(i)));
                }
                movesLeft.remove(Integer.valueOf(gameArray.get(i)));
            }
            for (int i = 8; i < gameArray.size(); i++) {
                if (i % 2 == 0) {
                    enemyMoves.remove(Integer.valueOf(gameArray.get(i)));
                    enemyMoves.add(Integer.valueOf(movesLeft.get(0)));
                    movesLeft.set(0, Integer.valueOf(gameArray.get(i)));
                } else {
                    myMoves.remove(Integer.valueOf(gameArray.get(i)));
                    myMoves.add(Integer.valueOf(movesLeft.get(0)));
                    movesLeft.set(0, Integer.valueOf(gameArray.get(i)));
                }
            }
        }
        
        if (game.gameSequence.isEmpty()) {
            //This block indicates first move of game.
            //myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
        } else if (game.gameSequence.size() == 8) {
            //This block indicates first move of ACHI.
            gb = new AchiBehavior();
            //myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
        } else if (game.gameSequence.size() > 8) {
            //This block indicates full ACHI mode.
            gb = new AchiBehavior();
            //myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
        } else {
            //This block indicates normal mode.
            //myNextMove = gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
        }
        return (int)gb.getMoveCommon(enemyMoves, movesLeft, myMoves);
    }

}
