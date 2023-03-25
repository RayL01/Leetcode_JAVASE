package com.shady.Arrays.TwoPointers;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        int cur = high;
        int [] res = new int[n];

        //[-4,-1,0,3,10]
        while(low <= high){
            if(Math.abs(nums[low]) >= Math.abs(nums[high])){
                res[cur] = nums[low] * nums[low];
                cur--;
                low++;
            }else{
                res[cur] = nums[high] * nums[high];
                cur--;
                high--;
            }
        }
        return res;

    }
}
