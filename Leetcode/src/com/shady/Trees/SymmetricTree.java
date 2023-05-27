package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/05/05/13:40
 * @Description:https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
  /**
   *           1
   *         2   2
   *      3   4   4   3
   *     1 2 1 2 1 2 2 1
   */
  public boolean isSymmetric(TreeNode root){
    if(root == null) return true;

    return traverse(root.left,root.right);
  }
  private boolean traverse(TreeNode left, TreeNode right){
    if(left == null && right == null) return true;
    if(left == null || right == null) return false;

    if(left.val != right.val) return false;

    return traverse(left.left, right.right) && traverse(left.right, right.left);
  }
}
