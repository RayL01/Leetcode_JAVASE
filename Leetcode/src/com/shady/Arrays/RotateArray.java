package com.shady.Arrays;

/**
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        //1,2,3,4,5,6,7

        //Since k might be larger than the length of the array
        k = k % nums.length;

        //reverse the whole array
        reverse(nums, 0, nums.length - 1);
        //7,6,5,4,3,2,1

        //reverse the first k elements
        reverse(nums, 0, k - 1);
        //5,6,7,4,3,2,1

        //reverse the rest of the array
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            end--;
            start++;
        }
    }
}
