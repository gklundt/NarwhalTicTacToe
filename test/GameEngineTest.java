/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gordon
 */
public class GameEngineTest {
    
    public GameEngineTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMove method, of class GameEngine.
     */
    @Test
    public void testGetMove() {
        int expResult = 0;
        int result = 0;
        System.out.println("getMove");
        GameData game = new GameData();
        game.player = game.player.PLAYER1;
        Engine instance = new Engine();
        
        expResult = 4;
        result = instance.getMove(game);
        game.gameSequence.add(result);
        assertEquals(expResult, result);
   
        expResult = 0;
        game.gameSequence.add(expResult);
        result = 1;
        game.gameSequence.add(result);
        assertNotEquals(expResult, result);
        
        expResult = 3;
        game.gameSequence.add(expResult);
        result = instance.getMove(game);
        game.gameSequence.add(result);
        assertNotEquals(expResult, result);
    }

    public class GameEngineImpl extends GameEngine {

        public int getMove(GameData game) {
            return 0;
        }
    }
    
}
