/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//this is a test pls ignore ;)

/**
 *
 * @author aftonmartin
 */
public class Main {

    public static void main(String args[]) {
        final GameData data;
        data = new GameData();
        AbstractProtocolAdapter pa = new ProtocolAdapter();
        pa.start("", data);

//            GameEngine ge = new Engine();
//            GameWindow gw = new GameWindow(new GameController());
    }
}
