package com.shady.DichotomousSearch;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/24/22:35
 * @Description:
 */
public class LeftBoundDichotomousSearch {
  int left_bound(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;

    //The Search Interval goes from "left" to "right" [left, right]
    // 1 2 3 3 3 3 4 5
    while(left <= right){
      int mid = left + (right - left)/2;
      if(nums[mid] < target){
        left = mid + 1;
      }else if(nums[mid] > target){
        right = mid - 1;

      }else if(nums[mid] == target){
        right = mid - 1;
      }
    }
    if(left >= nums.length){
      return -1;
    }

    return nums[left] == target ? left : -1;
    //[0, 1, 3, 4]2
  }
}
