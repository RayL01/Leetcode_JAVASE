package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/05/05/13:28
 * @Description: https://leetcode.com/problems/same-tree/
 */
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q){
    if(p == null && q == null) return true;
    if(p == null || q == null) return false;

    if(p.val != q.val) return false;

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
