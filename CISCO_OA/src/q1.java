/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/29/16:30
 * @Description:
 */
public class q1 {
  public static void funcRotate(int[][] matrix) {
    int n = matrix.length;

    // Step 1: Transpose the matrix
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < n; i++) {
      reverseRow(matrix[i]);
    }
  }

  private static void reverseRow(int[] row) {
    int start = 0;
    int end = row.length - 1;
    while (start < end) {
      int temp = row[start];
      row[start] = row[end];
      row[end] = temp;
      start++;
      end--;
    }
  }

  // Function to print the matrix
  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int value : row) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    funcRotate(matrix);
    printMatrix(matrix);
  }
}
