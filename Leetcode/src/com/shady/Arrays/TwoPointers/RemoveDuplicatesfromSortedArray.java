package com.shady.Arrays.TwoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/12/18:44
 * @Description: Delete duplicates in a sorted array and do not return a new array(modify the original array)
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
 */
public class RemoveDuplicatesfromSortedArray {
  class Solution {
    /**
     *  0 1 2 3 4 5 6 7
     *
     *
     *  0 0 1 1 2 3 3 4
     * @param nums
     * @return
     */
    //Using two pointers(slow and fast pointers)
    public int removeDuplicates(int[] nums) {
      int low = 0, high = 0;
      while(high != nums.length){
        if(nums[high] != nums[low]){
          nums[++low] = nums[high];
        }
        high++;
      }
      return low + 1;
    }
  }
}
