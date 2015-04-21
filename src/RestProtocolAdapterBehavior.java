
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestProtocolAdapterBehavior implements ProtocolAdapterBehaviorInterface {

    private String playerId;
    private final String[] apiBoard;
    private Player imPlayer;

    public RestProtocolAdapterBehavior() {
        this.apiBoard = new String[]{"", "", "", "", "", "", "", "", ""};
    }

    @Override
    public void start(String uri, GameData data) {

        data.gameMode = GameMode.NORMAL;

        if (data.gameId == null || data.gameId.length() == 0) {
            data.gameId = this.api_start();
            this.imPlayer = Player.PLAYER1;
        } else {
            this.imPlayer = Player.PLAYER2;
        }

        data.result = Result.NONE;
        data.timeLeft = 30000;
        this.playerId = this.api_connect(data.gameId);
        this.waitForMyTurn(data);
    }

    @Override
    public void getOpponentMove(GameData data) {
        // send my move
        int myMove = data.gameSequence.getLast();
        boolean accepted = this.api_move(data.gameId, this.playerId, myMove);
        if (accepted) {
            this.apiBoard[myMove] = this.imPlayer == Player.PLAYER1 ? "X" : "0";
            data.player = this.imPlayer == Player.PLAYER1 ? Player.PLAYER2 : Player.PLAYER1;
            this.waitForMyTurn(data);
        } else {
            data.gameSequence.removeLast();
        }

    }

    private void printGameData(GameData data) {
        System.out.printf("PlayerId: %s \n", this.playerId);
        System.out.printf("I\'m player: %s \n", this.imPlayer);
        System.out.printf("GameId: %s \n", data.gameId);
        System.out.printf("Mode: %s \n", data.gameMode);
        System.out.printf("Sequence: %s \n", data.gameSequence);
        System.out.printf("Player Turn: %s \n", data.player);
        System.out.printf("TimeLeft: %s \n", data.timeLeft);
        System.out.printf("Result: %s \n", data.result);
    }

    private void waitForMyTurn(GameData data) {
        System.out.println("Begin Waiting for My Turn");
        this.printGameData(data);

        int gamestatus = this.api_status(data.gameId);
        int myTurn = this.imPlayer == Player.PLAYER1 ? 1 : 2;
        int retries = 30;

        while (gamestatus != myTurn && gamestatus < 3 && retries > 0) {
            try {
                gamestatus = this.api_status(data.gameId);
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RestProtocolAdapterBehavior.class.getName()).log(Level.SEVERE, null, ex);
            }
            --retries;
        }

        switch (gamestatus) {
            case 1:
                this.api_grid(data.gameId, data);
                break;
            case 2:
                this.api_grid(data.gameId, data);
                break;
            case 3:
                data.result = this.imPlayer == Player.PLAYER1 ? Result.WIN : Result.LOSE;
                break;
            case 4:
                data.result = this.imPlayer == Player.PLAYER2 ? Result.WIN : Result.LOSE;
                break;
            default:
                // dont' know ... we win!
                data.result = Result.WIN;
        }

        data.player = this.imPlayer;
        System.out.println("End Waiting for My Turn");
        this.printGameData(data);
        System.out.println();

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
            x = new URL("http://cs2.uco.edu/~gq011/tictactoe/server/?controller=api&method=move&gameid=" + gameId + "&playerid=" + playerId + "&position=" + move);
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
        return !content.toString().trim().isEmpty();
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
        String[] s = content.toString().split(",");
        for (int i = 0; i < s.length; ++i) {
            s[i] = s[i].replace("[", "").replace("\"", "").replace("]", "").toUpperCase();
            if (!s[i].trim().equals(this.apiBoard[i])) {
                this.apiBoard[i] = s[i];
                if (data.gameSequence.size() < 8) {
                    data.gameSequence.add(i);
                    break;
                } else {
                    if (s[i].trim().isEmpty()) {
                        data.gameSequence.add(i);
                    }
                }
            }
        }
    }
}
