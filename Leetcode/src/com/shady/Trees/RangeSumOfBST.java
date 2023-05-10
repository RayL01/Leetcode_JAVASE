package com.shady.Trees;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {

    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        traverse(root,low,high);
        return sum;
    }
    private void traverse(TreeNode root, int low, int high){
        if(root == null) return;

        if(root.val > high) {
            traverse(root.left, low, high);
        }else if(root.val < low){
            traverse(root.right, low, high);
        }else{
            //root.val is between low and high
            sum += root.val;
            traverse(root.left, low, root.val);
            traverse(root.right, root.val, high);

        }

    }

}
