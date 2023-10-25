import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/14/21:49
 * @Description:
 */
public class matrixMatch {

    public static void main(String[] args) {
      int[][] board = {
              {2, 4, 2, 4, 2},
              {4, 1, 4, 2, 2},
              {1, 4, 2, 5, 3}
      };
      char[][] pattern = {
              {'4', 'c'},
              {'c', 'b'}
      };

      int[] result = findSubmatrix(board, pattern);
      System.out.println("Result: (" + result[0] + ", " + result[1] + ")");
    }

    public static int[] findSubmatrix(int[][] board, char[][] pattern) {
      int rows = board.length, cols = board[0].length;
      int pRows = pattern.length, pCols = pattern[0].length;

      for (int i = 0; i <= rows - pRows; i++) {
        for (int j = 0; j <= cols - pCols; j++) {
          HashMap<Character, Integer> charToDigit = new HashMap<>();

          boolean isMatch = true;

          for (int x = 0; x < pRows; x++) {
            for (int y = 0; y < pCols; y++) {
              int boardVal = board[i + x][j + y];
              char patternVal = pattern[x][y];

              if (Character.isDigit(patternVal)) {
                if (boardVal != Character.getNumericValue(patternVal)) {
                  isMatch = false;
                  break;
                }
              } else {

                //First, we should determine whether this letter exists in the map
                if (charToDigit.containsKey(patternVal)) {

                  //See if the value matches
                  if (!charToDigit.get(patternVal).equals(boardVal)) {
                    isMatch = false;
                    break;
                  }
                } else {
                  //it this letter doesn't exist in the map, we should check whether the value set of the map contains the  value of the current letter.
                  if(charToDigit.containsValue(boardVal)
                  ){
                    isMatch = false;
                    break;
                  }
                  //otherwise, this current value is different from those already in the map.
                  charToDigit.put(patternVal, boardVal);
                }
              }
            }
          }

          if (isMatch) {
            return new int[]{i, j};
          }
        }
      }

      return new int[]{-1, -1};
    }


}
