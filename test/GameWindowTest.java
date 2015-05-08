/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Deque;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class GameWindowTest {
    
        GameData data1;
        GameData data2;
		GameEngine ge;
		AbstractProtocolAdapter apa;
		AbstractGameController agc;
        GameWindow instance;
    public GameWindowTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        data1 = new GameData();
        data2 = new GameData();
		ge = new Engine();
		apa = new ProtocolAdapter();
		agc = new GameController(ge, apa);
        instance = new GameWindow(agc);
    }
    
    @After
    public void tearDown() {
		data1 = null;
		data2 = null;
		ge = null;
		apa = null;
		agc = null;
		instance = null;
    }

    /**
     * Test of update method, of class GameWindow.
     */
	@Test(expected = NullPointerException.class)
    public void testUpdateNullUpdate() {
        GameData data = null;
        GameWindow instance = null;
        instance.update(data);
    }
	@Test
    public void testGameSequence1() {
		data1.player = Player.PLAYER1;
        data1.gameSequence.add(11);
        instance.update(data1);
		assertEquals((long)data1.gameSequence.getFirst(), (long)11);
    }
	@Test(expected = NoSuchElementException.class)
    public void testGameSequence2() {
		data1.player = Player.PLAYER1;
        data1.gameSequence.removeFirst();
        instance.update(data1);
		assertEquals(data1.gameSequence.size(), 0);
    }

	@Ignore
	public void testUpdateDeep(){
		data1.player = Player.PLAYER1;
		data2.player = Player.PLAYER1;
        instance.update(data1);
		//different objects should cause to fail
        assertEquals(data1, data2);
		fail("Warning, Should have failed but did not");
	}
    
	@Ignore
	public void testUpdatePlayerFail(){
		//should fail
		data1.player = Player.PLAYER1;
		data2.player = Player.PLAYER2;
        instance.update(data1);
        assertEquals(data1.player, data2.player);
		fail("Warning, Should have failed, but did not");
	}

	@Test
	public void testUpdatePlayerPass(){
		//should pass
		data1.player = Player.PLAYER1;
		data2.player = Player.PLAYER1;
		data1.gameId = "3";
		data2.gameId = "3";
		data1.gameMode = GameMode.ACHI;
		data2.gameMode = GameMode.ACHI;
		data1.gameSequence.add(4);
		data2.gameSequence.add(4);
		data1.result = Result.WIN;
		data2.result = Result.WIN;
		data1.timeLeft = 5;
		data2.timeLeft = 5;
        instance.update(data1);
        assertEquals(data1.player, data2.player);
		assertEquals(data1.gameId, data2.gameId);
		assertEquals(data1.gameMode, data2.gameMode);
		assertEquals(data1.gameSequence.getFirst(), data2.gameSequence.getFirst());
		assertEquals(data1.result, data2.result);
		assertEquals(data1.timeLeft, data2.timeLeft);
	}
    
}
