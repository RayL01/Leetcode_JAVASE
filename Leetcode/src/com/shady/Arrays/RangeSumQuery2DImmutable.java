package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/15/16:51
 * @Description:
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 */
public class RangeSumQuery2DImmutable {
  class NumMatrix {
    int pre[][];
    public NumMatrix(int[][] matrix) {
      int m = matrix.length;//row length
      int n = matrix[0].length;//column length
      if(m==0 || n == 0) return;
      pre = new int[m + 1][n + 1];//all elements are initialized as 0
      //Since it's too complicated to implement a pre matrix with size m * n(You have to write a lot of if-else cases for m = 0 || n =0)

      for (int i = 1; i <= m; i++) {// we start with 1, 1 and treat 1, 1 as 0,0 in the original 2D matrix
        for (int j = 1; j <= n; j++) {
          pre[i][j] = pre[i][j - 1] + pre[i - 1][j] - pre[i - 1][j - 1] + matrix[i - 1][j - 1];
        }

      }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
      //Be ca
      return pre[row2 + 1][col2 + 1] - pre[row2 + 1][col1] - pre[row1][col2 + 1] + pre[row1][col1];
    }
  }
}
