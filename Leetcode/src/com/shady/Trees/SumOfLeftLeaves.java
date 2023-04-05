package com.shady.Trees;


/**
 * https://leetcode.com/problems/sum-of-left-leaves/
 */
public class SumOfLeftLeaves {

    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }
    private void traverse(TreeNode root){
        if(root == null) return;

        if(root.left != null && root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }


        traverse(root.left);
        traverse(root.right);
    }

}
