package com.shady;

public class InsertintoaBinarySearchTree {
  class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {//in order to insert, first we need to find the right position until we get the leaf node, and insert the val at the null.

      if(root == null){
        return new TreeNode(val);
      }
      if(root.val < val){
        root.right = insertIntoBST(root.right, val);
      }
      if(root.val > val){
        root.left = insertIntoBST(root.left, val);
      }
      return root;

    }
  }
}
