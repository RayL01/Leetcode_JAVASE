package com.shady.Trees;

public class SearchinaBinarySearchTree {
  class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
      if(root == null){
        return null;
      }
      if(root.val < val){
        searchBST(root.right, val);
      }
      if(root.val > val){
        searchBST(root.left, val);
      }
      return root;
    }
  }
}
