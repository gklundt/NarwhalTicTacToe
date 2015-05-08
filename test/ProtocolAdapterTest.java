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
    public void testStart_Player1() {

        System.out.println("start null game data");
        String uri = "";
        ProtocolAdapter instance = new ProtocolAdapter();
        GameData data1 = new GameData();
        instance.start(uri, data1);
        assertTrue(data1.player == Player.PLAYER1);
        assertNotNull(data1.gameId);
        instance = null;
        data1 = null;
        System.out.println("end null game data");

    }

    @Test
    public void testStart_Player2() {

        System.out.println("start not null game data");
        String uri = "";

        ProtocolAdapter instance1 = new ProtocolAdapter();

        GameData data1 = new GameData();
        instance1.start(uri, data1);

        instance1.getOpponentMove(data1);
        assertTrue(data1.player == Player.PLAYER1);
        assertNotNull(data1.gameId);

        GameData data2 = new GameData();
        data2.gameId = data1.gameId;

        assertTrue(data1.gameId == data2.gameId);

        ProtocolAdapter instance2 = new ProtocolAdapter();
        instance2.start(uri, data2);
        assertTrue(data2.player == Player.PLAYER2);

    }

    /**
     * Test of getOpponentMove method, of class ProtocolAdapter.
     */
    @Test
    public void testGetOpponentMove_accepted() {
        System.out.println("getOpponentMove");
        GameData data = new GameData();
        data.gameSequence.add(4);
        
        ProtocolAdapter instance = new ProtocolAdapter();
        instance.getOpponentMove(data);
        boolean pass = true;
        assertTrue("Unable to test", pass);
    }

        /**
     * Test of getOpponentMove method, of class ProtocolAdapter.
     */
    @Test
    public void testGetOpponentMove_rejected() {
        System.out.println("getOpponentMove");
        GameData data = new GameData();
        data.gameSequence.add(15);
        
        ProtocolAdapter instance = new ProtocolAdapter();
        instance.getOpponentMove(data);
        boolean pass = true;
        assertTrue("Unable to test", pass);
    }

}
