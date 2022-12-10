package com.shady.MonotonicStack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/09/22:46
 * @Description:
 * https://leetcode.com/problems/next-greater-element-ii/
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 */
public class NextGreaterElementII {
  /**
   * To simulate a circle based on the array, we could double the size of the array.
   *
   * But there's a little trick for creating a double-sized array, we can modulo each index of the array.
   * @param nums
   * @return
   */
  public int[] nextGreaterElements(int[] nums) {
    /**
     * 2 1 2 4 3 | 2 1 2 4 3
     *
     * 4 2 4 -1 4
     */
    Stack<Integer> stack = new Stack<>();
    int n = nums.length;
    int[] res = new int[n];
    for(int i = 2 * n - 1;i >= 0; i--){
      //First we should check whether the current element is larger than elements in the stack
      while(!stack.empty() && stack.peek() <= nums[i % n]){
        stack.pop();
      }
      res[i % n] = !stack.empty() ? stack.peek() : -1;
      stack.push(nums[i % n]);
    }
    return res;


  }
}
