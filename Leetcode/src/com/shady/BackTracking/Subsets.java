package com.shady.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/02/14/01:08
 * @Description: Subsets solved by backtracking
 * https://leetcode.com/problems/subsets/
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {

  //Store the result
  List<List<Integer>> res = new ArrayList<>();
  LinkedList<Integer> track = new LinkedList<>();
  public List<List<Integer>> subsets(int[] nums) {
      backtrack(nums,0);
      return res;
  }

  /**
   *
   * @param nums
   * @param start is the starting index in the for loop
   */
  private void backtrack(int[] nums, int start){
    //pos of preorder, we store the track into res.

    //do not add track directly
    res.add(new LinkedList<>(track));

    for (int i = start; i < nums.length; i++) {
      //make a choice
      track.add(nums[i]);

      backtrack(nums, i + 1);

      //Undo
      track.removeLast();
    }
  }
}
