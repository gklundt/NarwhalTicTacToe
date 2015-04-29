import java.util.*;

public class RandomBehavior implements GameBehavior {

    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        int position = 0;
        Random number = new Random();
        do {
            position = (number.nextInt(9));
        } while(enemyMoves.contains(position) && myMoves.contains(position));
        return position;
    }
}
