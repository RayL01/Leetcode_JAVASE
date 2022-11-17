package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/16/22:39
 * @Description: car pooling solved by difference array
 * https://labuladong.github.io/algo/2/20/25/
 */
public class carPooling {
  class Difference{
    private int[] diff;
    public Difference(int[] nums){
      diff = new int[nums.length];
      // 1 2  0  8  -1  7 original array
      // 1 1 -2  8  -9  8 difference array
      diff[0] = nums[0];
      for (int i = 1; i < diff.length; i++) {
        diff[i] = nums[i] - nums[i - 1];
      }
    }
    /**
     * increase the value of the original array in the given indexes.
     * @param low
     * @param high
     * @param val
     */

    // 1 2  0  8  -1  7 original array
    // 1 1 -2  8  -9  8 difference array
    public void modify(int low, int high, int val){
      diff[low] += val;
      if(high < diff.length - 1){//since if high is at the last index, there's no need to do this.
        diff[high + 1] -= val;//In this case, elements positioned behind high will not increase.

      }
    }

    /**
     * Return the result array
     */
    // 1 2  0  8  -1  7 original array
    // 1 1 -2  8  -9  8 difference array
    public int[] getResult(){
      int res[] = new int[diff.length];
      res[0] = diff[0];
      for (int i = 1; i < diff.length; i++) {
        res[i] = diff[i] + res[i - 1];
      }
      return res;
    }

  }
  public boolean carPooling(int[][] trips, int capacity) {
      int[] sums = new int[1001];//the length of the difference array
      Difference difference = new Difference(sums);
    for (int[] trip : trips){
//      Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//      Output: false
      difference.modify(trip[1], trip[2] - 1, trip[0]);
    }
    int[] res = difference.getResult();
    for (int i = 0; i < res.length; i++) {
      if(res[i] > capacity){
        return false;
      }
    }
    return true;
  }


}
