/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/29/17:01
 * @Description:
 */
public class q3 {
  public static int funcMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      int maxRow = Integer.MIN_VALUE;
      int colIdx = -1;

      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] > maxRow) {
          maxRow = matrix[i][j];
          colIdx = j;
        }
      }

      int minCol = Integer.MAX_VALUE;
      for (int k = 0; k < matrix.length; k++) {
        if (matrix[k][colIdx] < minCol) {
          minCol = matrix[k][colIdx];
        }
      }

      if (maxRow == minCol) {
        return maxRow;
      }
    }
    return -1;
  }
}
