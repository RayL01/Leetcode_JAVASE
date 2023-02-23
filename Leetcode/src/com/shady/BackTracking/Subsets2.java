package com.shady.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    List<List<Integer>> res;
    List<Integer> track;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         res = new ArrayList<>();
         track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }


    /**
     * First, we should sort the array so that we can remove the branch with the same value;
     * @param nums
     * @param start
     */
    void backtrack(int[] nums, int start){
        //Since every node is a subset, we add it to the res array at the pre-order position.
        res.add(new ArrayList<>(track));


        for (int i = start; i < nums.length; i++) {
            //jump the duplicated branch
            if(i != start && nums[i] == nums[i - 1]) continue;


            track.add(nums[i]);

            backtrack(nums, i + 1);

            track.remove(track.size() - 1);

        }
    }

}
