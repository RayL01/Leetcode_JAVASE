package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/15/14:58
 * @Description:
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
public class RangeSumQueryImmutable {
  class NumArray {
    int[] pre;//Sacrifice space complexity  for time complexity
    public NumArray(int[] nums) {
        pre = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        // 1 2 3 4  5  6
        // 1 3 6 10 15 21
        if(i == 0){
          pre[i] = nums[i];
          continue;
        }
        pre[i] = pre[i - 1] + nums[i];
      }
    }

    public int sumRange(int left, int right) {
      // 1 2 3 4 5

      if(left == 0){
        return pre[right];
      }
      return pre[right] - pre[left - 1];
    }
  }
}
