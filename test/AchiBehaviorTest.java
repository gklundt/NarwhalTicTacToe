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
public class AchiBehaviorTest {
    
    public AchiBehaviorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMoveCommon method, of class AchiBehavior.
     */
    @Test
    public void testGetMoveCommon() {
        ArrayList<Integer> enemyMoves, movesLeft, myMoves;
        enemyMoves = new ArrayList<>();
        movesLeft = new ArrayList<>();
        myMoves = new ArrayList<>();

        enemyMoves.add(0);
        enemyMoves.add(1);
        enemyMoves.add(6);
        enemyMoves.add(7);
        
        myMoves.add(2);
        myMoves.add(3);
        myMoves.add(4);
        myMoves.add(8);
        
        movesLeft.add(5);
        
        
        System.out.println("getMoveCommon");
        GameData game = null;
        TicTacToeBehavior instance = new TicTacToeBehavior();
        int expResult = 5;
        int result = instance.getMoveCommon(enemyMoves, movesLeft, myMoves);
        assertEquals(expResult, result);
    }
    
}
