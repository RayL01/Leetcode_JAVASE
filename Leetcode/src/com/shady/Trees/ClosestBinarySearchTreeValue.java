package com.shady.Trees;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 */
public class ClosestBinarySearchTreeValue {
    int res = Integer.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        traverse(root, target);
        return res;
    }

    /**
     * Traverse the whole tree and store the closest value in the global variable res.
     * @param root
     * @param target
     */
    private void traverse(TreeNode root, double target){
        if(root == null) return;


        //Update res;
        if(Math.abs(root.val - target) <= Math.abs(res - target)){
            res = root.val;
        }

        if(root.val > target){
            traverse(root.left, target);
        }else{
            traverse(root.right,target);
        }

    }

}
