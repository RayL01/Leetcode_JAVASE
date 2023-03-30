package com.shady.Trees;

public class SumOfRootToLeafBinaryNumber {
    int path = 0;
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root == null) return;

        path = path << 1 | root.val;

        if(root.left == null && root.right == null){
            res += path;
        }

        traverse(root.left);
        traverse(root.right);

        path = path >> 1;
    }
}
