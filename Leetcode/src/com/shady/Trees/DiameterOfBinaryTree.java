package com.shady.Trees;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
public class DiameterOfBinaryTree {
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        traverse(root);
        return maxDiameter;
    }

    //Return the maximum depth of the current tree and update the longest path in the current treeroot
    private int traverse(TreeNode root){
        //set up the base case
        if(root == null) return 0;



        int left = traverse(root.left);
        int right = traverse(root.right);

        //Update the global variable

        maxDiameter = Math.max(maxDiameter, left + right);

        return 1+ Math.max(left, right);
    }
}
