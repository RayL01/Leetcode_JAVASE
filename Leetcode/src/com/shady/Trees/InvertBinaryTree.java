package com.shady.Trees;


//Given the root of a binary tree, invert the tree, and return its root.
//TIme: O(n) Space: O(h) since h = O(n) , hence O(n)
public class InvertBinaryTree {
  class Solution {
    public TreeNode invertTree(TreeNode root){
      traverse(root);
      return root;
    }
    public void traverse(TreeNode root) {
      //Use pre-order traversing mechanism
      if(root == null){
        return;
      }
      TreeNode tmpNode = root.left;
      root.left = root.right;
      root.right = tmpNode;
      traverse(root.left);
      traverse(root.right);

    }
  }
}
