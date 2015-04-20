
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gordon
 */
public class RestProtocolAdapterBehavior implements ProtocolAdapterBehaviorInterface {

    private String playerId;

    @Override
    public void start(String uri, GameData data) {

        data.gameId = (data.gameId == null || data.gameId.length() == 0) ? this.api_start() : data.gameId;
        data.gameMode = GameMode.NORMAL;
        // todo: set data.gameSequence
        data.player = Player.PLAYER1;
        data.result = Result.NONE;
        data.timeLeft = 30000;
        this.playerId = this.api_connect(data.gameId);
        System.out.printf("PlayerId: %s \n", this.playerId);

    }

    @Override
    public void getOpponentMove(GameData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String api_start() {
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=start");
            URLConnection urlConnection = x.openConnection();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProtocolAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProtocolAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content.toString().trim();
    }

    private String api_connect(String gameId) {
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=connect&gameid=" + gameId);
            URLConnection urlConnection = x.openConnection();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProtocolAdapter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProtocolAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content.toString().trim();
    }

    private int api_status(String gameId) {
        return 0;
    }

    private String api_mode(String gameId) {
        return "";
    }

    private boolean api_move(String gameId, String playerId, int move) {
        return true;
    }

    private ArrayList<Integer> api_grid(String gameId) {
        return new ArrayList<>();
    }

}
