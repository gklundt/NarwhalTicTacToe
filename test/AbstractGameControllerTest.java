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
public class AbstractGameControllerTest {
    
    public AbstractGameControllerTest() {
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
     * Test of subscribe method, of class AbstractGameController.
     */
    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        GameObserver obs = null;
        AbstractGameController instance = null;
        instance.subscribe(obs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of notifyObservers method, of class AbstractGameController.
     */
    @Test
    public void testNotifyObservers() {
        System.out.println("notifyObservers");
        AbstractGameController instance = null;
        instance.notifyObservers();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class AbstractGameController.
     */
    @Test
    public void testStart_String() {
        System.out.println("start");
        String uri = "";
        AbstractGameController instance = null;
        instance.start(uri);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of start method, of class AbstractGameController.
     */
    @Test
    public void testStart_String_String() {
        System.out.println("start");
        String uri = "";
        String code = "";
        AbstractGameController instance = null;
        instance.start(uri, code);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractGameControllerImpl extends AbstractGameController {

        public AbstractGameControllerImpl() {
            super(null, null);
        }

        public void subscribe(GameObserver obs) {
        }

        public void notifyObservers() {
        }

        public void start(String uri) {
        }

        public void start(String uri, String code) {
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}
