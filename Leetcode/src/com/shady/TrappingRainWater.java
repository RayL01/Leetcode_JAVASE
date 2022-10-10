package com.shady;

public class TrappingRainWater {
  /**
   * Time complexity : O(n)
   * Space complexity : O(1)
   * Using two pointers
   */
  class Solution {
    public int trap(int[] height) {
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int totalTrappingWater = 0;
        int left = 1;
        int right = height.length - 1;
        while (left < right){
          if(maxLeft <= maxRight) {

            if(height[left] > maxLeft){//大于当前maxleft的话就更新maxLeft，并且不能trap water
              maxLeft = height[left];
            }else{//小于当前maxleft的话就更新maxleft，并且trap water
              totalTrappingWater += (maxLeft - height[left]);
            }
            left++;
          }else{//max right > max left， now when have to start on the height[right]
            if(height[right] > maxRight){
              maxRight = height[right];
            }else{
              totalTrappingWater +=(maxRight - height[right]);
            }
            right++;
          }
        }



        return totalTrappingWater;
    }
  }
}
