package com.shady.BackTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/06/13:16
 * @Description:
 * https://leetcode.com/problems/permutations
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
  List<List<Integer>> res;
  boolean visited[];
  public List<List<Integer>> permute(int[] nums) {
    res = new ArrayList<>();

    //Store the visited path
    visited = new boolean[nums.length];//Initialized as false
    List<Integer> per = new ArrayList<>();

    backtrack(per, 0, nums);
    return res;
  }

  /**
   * num is the position for adding the number, board is the structure to store the current permutation
   * @param per
   * @param num
   * @param nums
   */


  void backtrack(List<Integer> per, int num,int[] nums){
    //The board has been filled with queens, and we should return.

    if(num == nums.length) {
      res.add(new ArrayList<>(per));
      return;
    }

    //Then we should traverse the current row by loop

    //Calculate the size of the column

    //nums.length is the number of choices at each position
    for (int pos = 0; pos < nums.length; pos++) {

      //First we should check whether this number is already visited
      if(visited[pos]) continue;

      //Select
      per.add(num,nums[pos]);
      //And we should set visited to true

      //1 , 2, 3
      //f , f, f

      visited[pos] = true;
      //1, 2, 3
      //t, f, f


      //Then we should traver the next position in the permutation
      backtrack(per, num + 1, nums);

      //Then we should undo our previous operations
      per.remove(num);
      //And don't forget to reset the visited array
      visited[pos] = false;


    }
  }


}
