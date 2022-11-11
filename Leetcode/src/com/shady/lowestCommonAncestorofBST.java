package com.shady;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/11/14:31
 * @Description:
 */
public class lowestCommonAncestorofBST {
  class solution{
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
      //Since we must utilize the property of the binary search tree, we must determine
      //which root value is bigger.
      int val1 = Math.min(p.val, q.val);
      int val2 = Math.max(p.val, q.val);
      return Find(root, val1, val2);
    }
    TreeNode Find(TreeNode root, int min, int max){
      //First of all, build the base case
      if(root == null){
        return null;
      }

      if(root.val >= min && root.val <= max){
        return root;
      }else if(root.val < min){
        return Find(root.right, min, max);
      }else{
        return Find(root.left, min, max);
      }
    }
  }
}
