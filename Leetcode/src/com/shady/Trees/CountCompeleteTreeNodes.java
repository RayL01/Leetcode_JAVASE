package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/11/15:49
 * @Description: Count the number of nodes in a complete binary tree
https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompeleteTreeNodes {
  class Solution{
    public int countNodes(TreeNode root){
      //First, we need to build up the base case
//      if(root == null){
//        return 0;
//      }
      // The base case can be commented since if left and right == null, it can be calculated by the pow() function.


      //And we need to determine whether the current tree is a perfect binary tree.
      //If so, we can calculate the number of nodes based on the height of the current tree.
      //We can verify a perfect binary tree by counting the length of path starting from both left and right
      TreeNode left = root;
      TreeNode right = root;
      int l = 0;
      int r = 0;
      while(left != null){
        l++;
        left = left.left;
      }
      while(right != null){
        r++;
        right = right.right;
      }

      if(l == r){//This means the current tree is  a perfect binary tree
        return (int)  Math.pow(2, l) - 1;
      }
      //else we need to treat it as a normal binary tree and count nodes recursively
      return 1 + countNodes(root.left) + countNodes(root.right);

    }
  }
}
