package com.shady.Trees;

public class BalancedBinaryTree {
    boolean isBalanced = true;
    public boolean isBalanced(TreeNode root){
        traverse(root);
        return isBalanced;
    }
    private int traverse(TreeNode  root){
        if(root == null) return 0;

        int left = traverse(root.left);
        int right = traverse(root.right);

        if(Math.abs(left - right) > 1) isBalanced = false;

        return 1 + Math.max(left, right);
    }
}
