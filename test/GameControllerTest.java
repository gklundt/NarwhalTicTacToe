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
public class GameControllerTest {
    
    public GameControllerTest() {
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
     * Test of subscribe method, of class GameController.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        GameObserver obs = null;
        GameController instance = null;
        instance.subscribe(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class GameController.
     */
    @Test
    public void testStart_String() {
        System.out.println("start");
        String uri = "";
        GameController instance = null;
        instance.start(uri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class GameController.
     */
    @Test
    public void testStart_String_String() {
        System.out.println("start");
        String uri = "";
        String code = "";
        GameController instance = null;
        instance.start(uri, code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class GameController.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        GameController instance = null;
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class GameController.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        GameController instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
