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
        AbstractProtocolAdapter pa = new ProtocolAdapter();
        GameEngine ge = new Engine();
        AbstractGameController gc = new GameController(ge,pa);
        GameWindow gw = new GameWindow(gc);
    }
}
