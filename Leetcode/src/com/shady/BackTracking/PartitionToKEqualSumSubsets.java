package com.shady.BackTracking;

import com.shady.EncodeAndDecode;

import org.junit.Test;

import java.io.DataInput;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/06/18:52
 * @Description:
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets
 *
 */
public class PartitionToKEqualSumSubsets {

  //We created a memo to store the state of the current used boolean array so that we don't have to do repeated recursions.
  HashMap<String, Boolean> memo = new HashMap<>();
  public boolean canPartitionkSubsets(int[] nums, int k){
    //Here we need to rule out some basic scenarios
    if(k > nums.length) return false;

    //Count the sum of nums and determine whether the sum can be divided by k. If not, return false here
    int sum = 0;
    for (int i: nums
         ) {
      sum += i;
    }
    if(sum % k != 0) return false;

    boolean[] used = new boolean[nums.length];

    //The total sum for each bucket
    int target = sum / k;
    return backtrack(k, 0, nums, 0, used, target);


  }

  /**
   *
   * @param k the number of the bucket we are traversing
   * @param bucket bucket is the current sum of numbers in this current bucket(k)
   * @param nums
   * @param start the starting index for the nums[] array
    * @param used boolen array to track the visited number
   * @param target the target sum in each bucket
   */
  public boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target){

    //Here we set up the base case for it
    if(k == 0){
      //All the buckets have been filled
      return true;
    }
    String state = Arrays.toString(used);
    if(memo.containsKey(state)){
      return memo.get(state);//Return the result directly
    }
    if(bucket == target){
      //We should jump into another recursion for the next bucket(k--)
      boolean res = backtrack(k - 1, 0, nums, 0, used, target);

      //Put the result for the current filled bucket into the memo
      memo.put(state, res);
      return res;
    }
    for(int i = start; i < nums.length; i++) {
      if(used[i]) continue; //nums[i] has been put into other bucket
      //And also, we should determine whether the sum of nums[i] and bucket exceeds target.
      if(nums[i] + bucket > target) continue;

      //Make a choice : put num[i] into current bucket
      bucket += nums[i];
      //don't forget to set used[i] as true here
      used[i] = true;

      //And also we need to jump into the next starting index for the current bucket, but we need to make sure that it will return true;
      if(backtrack(k, bucket, nums, i + 1, used, target)) return true;


      //Otherwise, it indicates that the current starting position is not good anymore, so we should undo our current choice and step into the next iteration
      used[i] = false;
      bucket -= nums[i];
    }
    //After the loop, we still can't find a solution, so we return false
    return false;
  }
  @Test
  public void test(){
    boolean[] res = new boolean[5];
    System.out.println(res.toString());
  }
}
