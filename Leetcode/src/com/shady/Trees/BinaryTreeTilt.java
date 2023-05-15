package com.shady.Trees;

/**
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class BinaryTreeTilt {
    int sum = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return sum;
    }
    private int traverse(TreeNode root){
        if(root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);
        sum += Math.abs(left - right);
        return root.val + left + right;
    }
}
