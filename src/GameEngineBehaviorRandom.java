import java.util.*;

public class GameEngineBehaviorRandom implements GameBehavior {

    @Override
    public int getMoveCommon(ArrayList myMoves, ArrayList enemyMoves) {
        int position = 0;
        Random number = new Random();
        do {
            position = (number.nextInt(9));
        } while(myMoves.contains(position) && enemyMoves.contains(position));
        return position;
    }
}
