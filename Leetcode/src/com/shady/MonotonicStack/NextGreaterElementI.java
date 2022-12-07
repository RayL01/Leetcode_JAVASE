package com.shady.MonotonicStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/06/21:25
 * @Description:
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElementI {


  public int[] nextGreaterElement1(int[] nums) {
    int n = nums.length;
    //In the monotonic stack, all elements are in decreasing order
    Stack<Integer> mstack = new Stack<>();

    int[] res = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      //First we have to check the elements in the stack must be larger than the current element in the array
      while(!mstack.empty() && nums[i] >= mstack.peek())//pop out all the elements that are smaller than the current element in the stack.
      {
        mstack.pop();
      }
      //after the while loop, elements remaining in the stack are ones that are larger than the current one in the decreasing order of the distance.

      res[i] = mstack.empty() ? -1 : mstack.peek();
      mstack.push(nums[i]);

    }
    return res;

  }
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    /**
     * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
     * Output: [-1,3,-1]
     * Explanation: The next greater element for each value of nums1 is as follows:
     * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
     * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
     */
    //Since the first array is the result of Finding the next greater element for each element in the array2.
    //We just need to check the corresponding value in the result array.
    //But if we use a for loop, that's way too time-consuming, we can use a map to do this.
    Map<Integer,Integer> map = new HashMap<>();
    int[] nextGreaterElement = nextGreaterElement1(nums2);
    int[] res = new int[nums1.length];
    for (int i = 0; i < nums2.length; i++) {
      map.put(nums2[i], nextGreaterElement[i]);
    }

    //Checking the map
    for (int i = 0; i < nums1.length; i++) {
      res[i] = map.get(nums1[i]);
    }
    return res;
  }
}
