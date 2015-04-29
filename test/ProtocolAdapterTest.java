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
public class ProtocolAdapterTest {
    
    public ProtocolAdapterTest() {
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
     * Test of start method, of class ProtocolAdapter.
     */
    @Test
    public void testStart() {
        System.out.println("start");
        String uri = "";
        GameData data = null;
        ProtocolAdapter instance = new ProtocolAdapter();
        instance.start(uri, data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpponentMove method, of class ProtocolAdapter.
     */
    @Test
    public void testGetOpponentMove() {
        System.out.println("getOpponentMove");
        GameData data = null;
        ProtocolAdapter instance = new ProtocolAdapter();
        instance.getOpponentMove(data);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
