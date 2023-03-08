package com.shady.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Author: shadyyyyyl
 * @Date: 2023/02/28/01:16
 * @Description:
 */
public class CombinationSum {
    List<List<Integer>> res;
    List<Integer> track;
    int trackSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        track = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        backtrack(candidates, 0, target);
        return res;
    }
    public void backtrack(int [] nums, int start, int target){
        //base case
        if(target == trackSum) {
            res.add(new ArrayList<>(track));
            return;
        }
        if(trackSum > target) return;
        for (int i = start; i < nums.length ; i++) {
            track.add(nums[i]);

            trackSum += nums[i];

            backtrack(nums, i, target);

            track.remove(track.size() - 1);
            trackSum -= nums[i];
        }

    }
}
