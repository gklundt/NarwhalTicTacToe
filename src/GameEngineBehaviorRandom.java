import java.util.*;

public class GameEngineBehaviorRandom implements GameBehavior {

    @Override
    public int getMoveCommon(GameData game) {
        int position = 0;
        Random number = new Random();
        do {
            position = (number.nextInt(9));
        } while(game.gameSequence.contains(position));
        return position;
    }
}
