package com.shady.Arrays.BinarySeach;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/04/22:36
 * @Description:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySeach {
  public int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    // 1 2 3 4 5


    //[-1,0,3,5,9,12]
    //9
    //0 1 2 3 4 5  6
    // 4 6
    while(low <= high){// "=" due to we
      int mid = low + (high - low) / 2;
      if(nums[mid] == target){
        return mid;
      }else if(nums[mid] > target){
        high = mid - 1;
      }else{
        low = mid + 1;
      }
    }


    return -1;
  }

  public int left_bound(int nums[], int target){
    int left = 0;
    int right = nums.length - 1;
    // 1 2 2 2 3 4 5     target = 4
    while(left <= right){
      int mid = left + (right - left) / 2;
      if(nums[mid] == target){//shifting left boundary
        right = mid - 1;
      }else if(nums[mid] < target){
        left = mid + 1;
      }else{
        right = mid - 1;
      }
    }

    //It's possible that the target is not in the array
    //And if the target is larger than all elements in the array, left will exceed the bound of the array, so we have to check on this.
    if(left == nums.length){
      return -1;
    }
    return nums[left] == target ? left : -1;
  }
  public int right_bound(int[] nums, int target){
    int left = 0;
    int right = nums.length - 1;
    while(left <= right){

      while(left <= right){
        int mid = left + (right - left) / 2;
        if(nums[mid] == target){
          left = mid + 1;//Since left would plus 1 in the end, so we have to return left -1
        }else if(nums[mid] < target){
          left = mid + 1;
        }else{
          right = mid - 1;
        }
      }
    }
    //if the target is less than all the elements in the array
    //when left = right == 0, mid == 0   and we have to move right to left and right = -1
    if(left == 0) return -1;
    return nums[left - 1] == target ? left - 1 : -1;
  }
}
