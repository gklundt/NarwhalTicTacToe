
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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

    @Override
    public void start(String uri, GameData data) {

        if (data.gameId == null || data.gameId.length() == 0) {
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

            data.gameMode = GameMode.NORMAL;
            data.result = Result.NONE;
            data.gameId = content.toString();
            data.player = Player.PLAYER1;

        } else {
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

            data.gameMode = GameMode.NORMAL;
            data.result = Result.NONE;
            data.gameId = content.toString();

        
        }

        
        
        
    }

    @Override
    public void getOpponentMove(GameData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
