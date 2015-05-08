/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gordon
 */
public class TicTacToeBehaviorTest {

    public TicTacToeBehaviorTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMoveCommon method, of class TicTacToeBehavior.
     */
    @Test
    public void testGetMoveCommon() {
        ArrayList<Integer> enemyMoves, movesLeft, myMoves;
        enemyMoves = new ArrayList<>();
        movesLeft = new ArrayList<>();
        myMoves = new ArrayList<>();

        enemyMoves.add(8);
        for (int i = 0; i < 8; i++) {
            movesLeft.add(i);
        }
        
        System.out.println("getMoveCommon");
        GameData game = null;
        TicTacToeBehavior instance = new TicTacToeBehavior();
        int expResult = 8;
        int result = instance.getMoveCommon(enemyMoves, movesLeft, myMoves);
        assertNotEquals(expResult, result);
    }

}
