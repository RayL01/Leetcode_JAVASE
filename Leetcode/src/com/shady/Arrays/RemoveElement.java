package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/12/21:56
 * @Description: Remove the required elements in the given array.
 * https://leetcode.com/problems/remove-element/submissions/
 */
public class RemoveElement {
  public int removeElement(int[] nums, int val) {
      int low = 0, high = 0;
    /**
     * 0 1 2 3 4 5 6 7
     *
     *
     * 0 0 1 1 2 3 3 4
     */
      while(high != nums.length){
        if(nums[high] != val){
          nums[low++] = nums[high];
        }
        high++;
      }
      //Since every time low++ will be executed, so low would be the actual length of the number in the result array
      return low;

  }
}
