
import java.util.*;

/**
 * 
 */
public class AchiBehavior implements GameBehavior {

    /**
     * 
     */
    /*int[] a = {1, 3, 4};
    int[] b = {0, 2, 4};
    int[] c = {1, 3, 5};
    int[] d = {0, 4, 6};
    int[] e = {0, 1, 2, 3, 5, 6, 7, 8};
    int[] f = {2, 4, 8};
    int[] g = {3, 4, 7};
    int[] h = {6, 4, 8};
    int[] i = {4, 5, 7};*/
    int[][] ar = {
        {1, 3, 4},
        {0, 2, 4},
        {1, 3, 5},
        {0, 4, 6},
        {0, 1, 2, 3, 5, 6, 7, 8},
        {2, 4, 8},
        {3, 4, 7},
        {6, 4, 8},
        {4, 5, 7}
    };
    public AchiBehavior() {
    }

    /** 
     * @return
     */
    @Override
    public int getMoveCommon(ArrayList<Integer> enemyMoves, ArrayList<Integer> movesLeft, ArrayList<Integer> myMoves) {
        int position = 0;
            for(int i = 0; i < ar[movesLeft.get(0)].length; i++) {
                if(myMoves.contains(ar[movesLeft.get(0)][i])){
                    position = ar[movesLeft.get(0)][i];
                    i = 100;
                }
            }
            myMoves.remove(position);
        return position;
    }

}