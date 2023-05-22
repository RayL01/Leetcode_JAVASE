package com.shady.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        int res = 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;

                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            if(sum > maxSum){
                maxSum = sum;
                res = level;

            }
        }
        return res;
    }
}
