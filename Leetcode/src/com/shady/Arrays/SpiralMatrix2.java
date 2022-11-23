package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/23/15:47
 * @Description:Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
 * Input: n = 3
 * Output: [[1,2,3],[8,9,4],[7,6,5]]
 * https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrix2 {
  public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];

    int upper_bound = 0, lower_bound = n - 1;
    int left_bound = 0, right_bound = n - 1;
    int count = 1;
    // res.size() == m * n 则遍历完整个数组
    while (true) {

      // 在顶部从左向右遍历
      int j;
      int i;
      //Start off at the top.

      for (i = left_bound; i <= right_bound; i++) {
        matrix[upper_bound][i] = count++;
      }
      //check
      if(i == left_bound){
        return matrix;
      }
      upper_bound++;

      for (j = upper_bound; j <= lower_bound; j++) {
        matrix[j][right_bound] = count++;
      }
      if(j == upper_bound){
        return matrix;
      }
      right_bound--;

      for (i = right_bound; i >= left_bound; i--) {
        matrix[lower_bound][i] = count++;
      }
      if(i == right_bound){
        return matrix;
      }
      lower_bound--;

      for (j = lower_bound; j >= upper_bound; j--) {
        matrix[j][left_bound] = count++;
      }
      if(j == lower_bound){
        return matrix;
      }
      left_bound++;
    }
  }

}
