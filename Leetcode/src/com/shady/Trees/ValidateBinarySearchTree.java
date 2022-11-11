package com.shady.Trees;

public class ValidateBinarySearchTree {
  class Solution {
    public boolean isValidBST(TreeNode root) {
      return Validate(root, null, null);
    }
    public boolean Validate(TreeNode root, TreeNode min, TreeNode max){//min means the minimal value of the current node, max means the maximal value of the current node
      if(root == null){
        return true;
      }
      if(min != null && root.val <= min.val){
        return false;
      }
      if( max != null && root.val >= max.val){
        return false;
      }
      return Validate(root.left, min, root)&&Validate(root.right, root, max);
    }
  }
}
