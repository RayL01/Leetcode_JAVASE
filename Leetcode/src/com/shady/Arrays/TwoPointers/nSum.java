package com.shady.Arrays.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/17/22:44
 * @Description:
 */

/**
 *
 */
public class nSum {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    //Don't forget to sort the array!!!!
      Arrays.sort(nums);
      return nSum(nums, 4, 0, target);
  }

  /**
   *
   * @param nums
   * @param n   the number of sums   '4' sum, '3' sum   '2' sum
   * @param start the starting index of the iteration
   * @param target
   * @return
   */
  private List<List<Integer>> nSum(int[] nums, int n, int start, int target){
    List<List<Integer>> res = new ArrayList<>();
    if(n == 2){
      //That's the base case
      int left = start;
      int right = nums.length - 1;
      while(left < right){
        long l = nums[left];
        long r = nums[right];
        long sum = l + r;
        if(sum < target){
          //left++, but we have to skip the duplicates
          while(nums[left] == l && left < right) left++;

        }else if(sum > target){
          //right--, but we have to skip the duplicates
          while(nums[right] == r && left < right) right--;
        }else{
          //we store the result to the res list array
          res.add(new ArrayList<>(Arrays.asList(nums[left],nums[right])));


          //sum equals target, and we should shrink the size of the current window and skip the duplicates in the meanwhile
          while(left < right && nums[left] == nums[left + 1]){
            left++;
          }
          //And don't forget to increase left again
          left++;

          while(left < right && nums[right] == nums[right - 1]) {
            right --;
          }
          right--;
        }
      }
    }else{//Recursively call the method
      //First we should enumerate all the numbers in the current array
      for (int i = start; i < nums.length; i++) {
        List<List<Integer>> cur = nSum(nums, n-1, i + 1, target - nums[i]);
        //Then we should add the current number to the res list
        for (List<Integer> lst: cur
             ) {
          lst.add(nums[i]);
          res.add(lst);
        }
        //When we want to proceed to the next number, we should skip the duplicates
        while(i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
      }
    }
    return res;
  }

}
