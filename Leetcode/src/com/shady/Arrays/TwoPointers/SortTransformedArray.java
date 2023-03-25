package com.shady.Arrays.TwoPointers;

/**
 * Given a sorted integer array nums and three integers a, b and c, apply a quadratic function of the form f(x) = ax2 + bx + c to each element nums[i] in the array, and return the array in a sorted order.
 * https://leetcode.com/problems/sort-transformed-array/
 */
public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        //
        int low = 0;
        int high = nums.length - 1;
        int [] res = new int[nums.length];
        int cur =  a > 0 ? high : 0;
        while(low <= high){
            int y1 = function(nums[low], a, b, c);
            int y2 = function(nums[high], a, b, c);
            if(a > 0){
                //this quadratic function opens upwards
                if(y1 >= y2){
                    res[cur] = y1;
                    low++;
                    cur--;
                }else{
                    res[cur] = y2;
                    high--;
                    cur--;
                }
            }else{
                //a < 0
                if(y1 <= y2){
                    res[cur] = y1;
                    cur++;
                    low++;
                }else{
                    res[cur] = y2;
                    cur++;
                    high--;
                }


            }
        }
        return res;
    }
    private int function(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}
