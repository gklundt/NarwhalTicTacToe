/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gordon
 */
public class GameEngineTest {
    
    public GameEngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
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
        System.out.println("getMove");
        GameData game = null;
        GameEngine instance = new GameEngineImpl();
        int expResult = 0;
        int result = instance.getMove(game);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameEngineImpl extends GameEngine {

        public int getMove(GameData game) {
            return 0;
        }
    }
    
}
