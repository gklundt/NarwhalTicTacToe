
import java.util.ArrayDeque;
import java.util.Deque;

public class GameData {

    public GameData(){
        this.gameSequence = new ArrayDeque<>();
    }
    public Deque<Integer> gameSequence;
    public int timeLeft;
    public GameMode gameMode;
    public Result result;
    public Player player;
    public String gameId;
    
}