package com.shady.Trees;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */

//Pretty much the same pattern as that of Diameter of binary tree
public class BinaryTreeMaximumPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    //Calculate and the maximum sum of path in one of the branches
    private int traverse(TreeNode root){
        if(root == null) return 0;


        //And we should notice that if the maximum value of one branch is negative, it should be dismissed as a '0'.

        int leftSum = Math.max(0, traverse(root.left));

        int rightSum = Math.max(0, traverse(root.right));

        //Calculate the maximum path value in the current root
        int max = root.val + leftSum + rightSum;

        //And determine the update of the global variable
        res = Math.max(res, max);


        //Implement the return value due to the definition of the whole recursive function
        return root.val + Math.max(leftSum, rightSum);
    }
}
