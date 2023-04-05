package com.shady.Trees;

/**
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
 */
public class BinarySearchTreeToGreaterSumTree {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    private void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.right);

        sum+=root.val;
        root.val = sum;


        traverse(root.left);
    }

}
