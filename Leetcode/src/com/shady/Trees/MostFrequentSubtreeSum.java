package com.shady.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/description/
 */
public class MostFrequentSubtreeSum {
    HashMap<Integer, Integer> sum = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        traverse(root);


        //now we should find the maximum count in the sum map;
        int maxCount  = 0;
        for (int i :sum.values()
             ) {
            maxCount = Math.max(maxCount, i);
        }
        List<Integer> list = new LinkedList<>();
        for (Integer key:sum.keySet()
             ) {
            if(sum.get(key) == maxCount){
                list.add(key);
            }
        }

        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
    private int traverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int res = left + right + root.val;
        sum.put(res, sum.getOrDefault(res, 0 ) + 1);

        return res;

    }
}
