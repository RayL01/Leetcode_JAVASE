package com.shady.Trees;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        //set up the base case
        if(root == null) return null;

        TreeNode  leftHead = increasingBST(root.left);
        root.left = null;

        TreeNode rightHead = increasingBST(root.right);
        root.right = rightHead;


        if(leftHead == null) return root;

        TreeNode p = leftHead;
        while(p != null && p.right != null) p = p.right;
        p.right = root;


        return leftHead;
    }
}
