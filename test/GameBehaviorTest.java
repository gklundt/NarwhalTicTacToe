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
public class GameBehaviorTest {
    
    public GameBehaviorTest() {
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
     * Test of getMoveCommon method, of class GameBehavior.
     */
    @Test
    public void testGetMoveCommon() {
        System.out.println("getMoveCommon");
        GameData game = null;
        GameBehavior instance = new GameBehaviorImpl();
        int expResult = 0;
        int result = instance.getMoveCommon(game);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameBehaviorImpl implements GameBehavior {

        public int getMoveCommon(GameData game) {
            return 0;
        }
    }
    
}
