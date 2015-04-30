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
public class AbstractProtocolAdapterTest {
    
    public AbstractProtocolAdapterTest() {
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
     * Test of start method, of class AbstractProtocolAdapter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        String uri = "";
        GameData data = null;
        AbstractProtocolAdapter instance = new AbstractProtocolAdapterImpl();
        instance.start(uri, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpponentMove method, of class AbstractProtocolAdapter.
     */
    @Test
    public void testGetOpponentMove() {
        System.out.println("getOpponentMove");
        GameData data = null;
        AbstractProtocolAdapter instance = new AbstractProtocolAdapterImpl();
        instance.getOpponentMove(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractProtocolAdapterImpl extends AbstractProtocolAdapter {

        public void start(String uri, GameData data) {
        }

        public void getOpponentMove(GameData data) {
        }
    }
    
}
