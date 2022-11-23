package com.shady.Arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/23/15:03
 * @Description:
 * https://leetcode.com/problems/spiral-matrix/submissions/
 */
public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {

    int m = matrix.length, n = matrix[0].length;
    int upper_bound = 0, lower_bound = m - 1;
    int left_bound = 0, right_bound = n - 1;
    List<Integer> res = new LinkedList<>();
    // res.size() == m * n 则遍历完整个数组
    while (true) {

      // 在顶部从左向右遍历
      int j;
      int i;
      //Start off at the top.

      for (i = left_bound; i <= right_bound; i++) {
        res.add(matrix[upper_bound][i]);
      }
      //check
      if(i == left_bound){
        return res;
      }
      upper_bound++;

      for (j = upper_bound; j <= lower_bound; j++) {
        res.add(matrix[j][right_bound]);
      }
      if(j == upper_bound){
        return res;
      }
      right_bound--;

      for (i = right_bound; i >= left_bound; i--) {
        res.add(matrix[lower_bound][i]);
      }
      if(i == right_bound){
        return res;
      }
      lower_bound--;

      for (j = lower_bound; j >= upper_bound; j--) {
        res.add(matrix[j][left_bound]);
      }
      if(j == lower_bound){
        return res;
      }
      left_bound++;
    }

  }

}
