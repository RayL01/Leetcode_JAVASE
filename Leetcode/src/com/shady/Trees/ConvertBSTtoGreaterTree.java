package com.shady.Trees;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        //In order to retrieve the values in the current parent node and its right sub-tree, the traversal order
        //must be right, root , left
        traverse(root);
        return root;
    }
    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.right);

        sum += root.val;
        root.val = sum;

        //in-order traversal position

        traverse(root.left);
    }
}
