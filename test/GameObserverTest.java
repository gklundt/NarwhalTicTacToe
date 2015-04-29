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
public class GameObserverTest {
    
    public GameObserverTest() {
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
     * Test of update method, of class GameObserver.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        GameData data = null;
        GameObserver instance = new GameObserverImpl();
        instance.update(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameObserverImpl implements GameObserver {

        public void update(GameData data) {
        }
    }
    
}
