/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Cody M.
 */

class Foo extends GameEngine implements GameObserver{

	@Override
	public void update(GameData data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMove(GameData game) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


public class GameControllerTest{
	
	GameObserver go;
	GameController gc;
	GameEngine ge;
	ProtocolAdapter pa;
    
    public GameControllerTest() {
    }
    
    
    @Before
    public void setUp() {
    	go = new Foo();
    	ge = new Foo();
    	pa = new ProtocolAdapter();
    	gc = new GameController(ge, pa);
    }
    
    @After
    public void tearDown() {
    	go = null;
    	gc = null;
    	pa = null;
    	pa = null;
    }

    /**
     * Test of subscribe method, of class GameController.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        GameObserver obs = go;
        GameController instance = gc;
        instance.subscribe(obs);
        
        assertTrue(gc.gameObservers.contains(obs));
    }

    /**
     * Test of start method, of class GameController.
     */
    @Test
    public void testStart_String() {
        System.out.println("start");
        String uri = "";
        GameController instance = gc;
        instance.start(uri);
        assertTrue(gc.getGd().result == Result.NONE);
    }

    /**
     * Test of start method, of class GameController.
     */
    @Test
    public void testStart_String_String() {
        System.out.println("start");
        String uri = "";
        String code = "";
        GameController instance = gc;
        instance.start(uri, code);
        assertTrue(gc.getGd().result == Result.NONE);
    }

    /**
     * Test of notifyObservers method, of class GameController.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        GameController instance = gc;
        instance.notifyObservers();
        assertTrue(true);
    }

    /**
     * Test of run method, of class GameController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        gc.setGd(new GameData());
        gc.getGd().result = Result.WIN;
        GameController instance = gc;
        instance.run();
        assertNull(gc.getGd());
    }
    
}
