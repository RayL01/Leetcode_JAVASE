package com.shady;

import com.shady.Trees.TreeNode;

//Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
//https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementinaBST {
  class Solution {
    int rank = 0;//record the current rank of the node value.
    int val = -1;// record the value of the node value
    public int kthSmallest(TreeNode root, int k) {

      traverse(root, k);
      return val;

    }
    public void traverse(TreeNode root, int k){
      if(root == null){
        return;
      }
      traverse(root.left, k);//preorder

      //inorder
      if(++rank == k){
        val = root.val;
        return;
      }

      traverse(root.right, k);
    }
  }
}
