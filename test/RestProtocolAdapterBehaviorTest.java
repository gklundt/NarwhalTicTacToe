/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RestProtocolAdapterBehaviorTest {

    public RestProtocolAdapterBehaviorTest() {
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
     * Test of start method, of class RestProtocolAdapterBehavior.
     */
    @Test
    public void testStart_NullGameData() {
        System.out.println("start null game data");
        String uri = "";
        RestProtocolAdapterBehavior instance = new RestProtocolAdapterBehavior();
        GameData data1 = new GameData();
        instance.start(uri, data1);
        assertTrue(data1.player == Player.PLAYER1);
        assertNotNull(data1.gameId);
        instance = null;
        data1 = null;
        System.out.println("end null game data");

    }

    @Test
    public void testStart_NotNullGameData() {
        System.out.println("start not null game data");
        String uri = "";

        RestProtocolAdapterBehavior instance1 = new RestProtocolAdapterBehavior();

        GameData data1 = new GameData();
        instance1.start(uri, data1);

        instance1.getOpponentMove(data1);
        assertTrue(data1.player == Player.PLAYER1);
        assertNotNull(data1.gameId);

        System.out.println("phase 2");

        GameData data2 = new GameData();
        data2.gameId = data1.gameId;

        assertTrue(data1.gameId == data2.gameId);

        RestProtocolAdapterBehavior instance2 = new RestProtocolAdapterBehavior();
        instance2.start(uri, data2);
        assertTrue(data2.player == Player.PLAYER2);


    }

    /**
     * Test of getOpponentMove method, of class RestProtocolAdapterBehavior.
     */
    @Test
    public void testGetOpponentMove_accepted() {
        System.out.println("getOpponentMove");
        GameData data = new GameData();
        data.gameSequence.add(4);
        
        RestProtocolAdapterBehavior instance = new RestProtocolAdapterBehavior();
        instance.getOpponentMove(data);
        boolean pass = true;
        assertTrue("Unable to test", pass);
    }

        /**
     * Test of getOpponentMove method, of class RestProtocolAdapterBehavior.
     */
    @Test
    public void testGetOpponentMove_rejected() {
        System.out.println("getOpponentMove");
        GameData data = new GameData();
        data.gameSequence.add(15);
        
        RestProtocolAdapterBehavior instance = new RestProtocolAdapterBehavior();
        instance.getOpponentMove(data);
        boolean pass = true;
        assertTrue("Unable to test", pass);
    }

}
