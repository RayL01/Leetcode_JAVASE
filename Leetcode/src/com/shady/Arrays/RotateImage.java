package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/22/21:33
 * @Description:
 * https://leetcode.com/problems/rotate-image/
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 */
public class RotateImage {
  public void rotate(int[][] matrix) {
    //First reflect the matrix on a diagonal line.
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix[0].length; j++) {
          int tmp = matrix[j][i];
          matrix[j][i] = matrix[i][j];
          matrix[i][j] = tmp;
      }
    }

    // reverse each row of the matrix
    for (int i = 0; i < matrix.length; i++) {
      int low = 0;
      int high = matrix[i].length - 1;
      while(low < high){
        int tmp = matrix[i][low];
        matrix[i][low] = matrix[i][high];
        matrix[i][high] = tmp;
        low++;
        high--;
      }

    }

  }
}
