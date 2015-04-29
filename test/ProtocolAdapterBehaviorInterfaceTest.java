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
public class ProtocolAdapterBehaviorInterfaceTest {
    
    public ProtocolAdapterBehaviorInterfaceTest() {
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
     * Test of start method, of class ProtocolAdapterBehaviorInterface.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        String uri = "";
        GameData data = null;
        ProtocolAdapterBehaviorInterface instance = new ProtocolAdapterBehaviorInterfaceImpl();
        instance.start(uri, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpponentMove method, of class ProtocolAdapterBehaviorInterface.
     */
    @Test
    public void testGetOpponentMove() {
        System.out.println("getOpponentMove");
        GameData data = null;
        ProtocolAdapterBehaviorInterface instance = new ProtocolAdapterBehaviorInterfaceImpl();
        instance.getOpponentMove(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ProtocolAdapterBehaviorInterfaceImpl implements ProtocolAdapterBehaviorInterface {

        public void start(String uri, GameData data) {
        }

        public void getOpponentMove(GameData data) {
        }
    }
    
}
