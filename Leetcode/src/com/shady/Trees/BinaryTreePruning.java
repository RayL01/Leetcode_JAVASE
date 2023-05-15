package com.shady.Trees;

public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return traverse(root) ? root : null;
    }
    private boolean traverse(TreeNode root){
        if(root == null) return false;

        boolean left = traverse(root.left);
        boolean right = traverse(root.right);
        if(left == false) root.left = null;
        if(right == false) root.right = null;

        return root.val == 1 || left || right;


    }
}
