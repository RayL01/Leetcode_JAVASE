package com.shady.Trees;

//You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:
//
//Create a root node whose value is the maximum value in nums.
//Recursively build the left subtree on the subarray prefix to the left of the maximum value.
//Recursively build the right subtree on the subarray suffix to the right of the maximum value.
//Return the maximum binary tree built from nums.
public class MaximumBinaryTree {
  class Solution {
    //Do it recursively
    //First, find the largest element in the given array
    //create a tree where the root node is the largest element in the current array
    //constructMaximumBinaryTree(root.left)//the index of the array shrinks
    //constructMaximumBinaryTree(root.right)
    //and also we need to find the base case, in this particular example, the base case is when the size of the array is 0
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      return build(nums, 0, nums.length -1);
    }
    public TreeNode build(int[]nums,int lo, int hi){
      //base case
      if(lo > hi){
        return null;
      }

      int index = -1;
      int maxVal = Integer.MIN_VALUE;
      for (int i = lo; i <= hi; i++) {//pay atteention to the value of i here, it should be lp instead of 0, and i should be <= but not <
        if(nums[i] > maxVal){
          index = i;
          maxVal = nums[i];
        }
      }
      TreeNode root = new TreeNode(maxVal);

      root.left = build(nums, lo, index - 1);
      root.right = build(nums, index + 1, hi);
      return root;
    }
  }

}
