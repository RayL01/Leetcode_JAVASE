package com.shady.BackTracking;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> res;
    List<Integer> track;


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, 0, target, 0);
        return res;
    }
    void backtrack(int[] nums, int start, int target, int trackSum){

        //base case
        if(trackSum == target){
            res.add(new ArrayList<>(track));
            return;
        }
        if(trackSum > target) return;


        for (int i = start; i < nums.length; i++) {
            //remove duplicates
            if(i != start && nums[i] == nums[i - 1]) continue;


            track.add(nums[i]);

            trackSum += nums[i];

            backtrack(nums, i + 1, target,  trackSum);

            //Undo
            track.remove(track.size() - 1);
            trackSum -= nums[i];
        }

    }
}
