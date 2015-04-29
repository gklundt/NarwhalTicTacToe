
import java.util.*;

public class RandomBehavior implements GameBehavior {

    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        boolean positionNotFound = true;
        int position = 0;
        Random number = new Random();
        do {
            position = (number.nextInt(9));
            if(positionNotFound)
                positionNotFound = myMoves.contains(position);
            if(positionNotFound)
                positionNotFound = enemyMoves.contains(position);
        } while (positionNotFound);
        System.out.println("Enemy: " + enemyMoves.contains(position));
        System.out.println("Me: " + myMoves.contains(position));
        return position;
    }
}
