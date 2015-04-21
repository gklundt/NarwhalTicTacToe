
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestProtocolAdapterBehavior implements ProtocolAdapterBehaviorInterface {

    private String playerId;

    @Override
    public void start(String uri, GameData data) {

        data.gameMode = GameMode.NORMAL;
        // todo: set data.gameSequence

        if (data.gameId == null || data.gameId.length() == 0) {
            data.gameId = this.api_start();
            data.player = Player.PLAYER1;
        } else {
            data.player = Player.PLAYER2;
        }

        data.result = Result.NONE;
        data.timeLeft = 30000;
        this.playerId = this.api_connect(data.gameId);
        System.out.printf("PlayerId: %s \n", this.playerId);

        while (this.api_status(data.gameId) == 0) {
            try {

//                System.out.printf("ID: %s \n"
//                        + "Mode: %s \n"
//                        + "Player: %s \n"
//                        + "Result: %s \n"
//                        + "Time: %s \n", data.gameId, data.gameMode, data.player, data.result, data.timeLeft);

                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RestProtocolAdapterBehavior.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void getOpponentMove(GameData data
    ) {
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
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=status&gameid=" + gameId);
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
        return Integer.parseInt(content.toString().trim());
    }

    private String api_mode(String gameId) {
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=mode&gameid=" + gameId);
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

    private boolean api_move(String gameId, String playerId, int move) {
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=move&gameid=" + gameId +"&playerid=" + playerId + "&position=" + move);
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
        return Boolean.parseBoolean(content.toString().trim());
    }

    private void api_grid(String gameId, GameData data) {
        StringBuilder content = new StringBuilder();
        try {
            URL x;
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=grid&gameid=" + gameId);
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
        //API returns ...
        //["X","O","O","","X","X","","","O"]
        
        //todo: update data.gameSequence

    }

}
