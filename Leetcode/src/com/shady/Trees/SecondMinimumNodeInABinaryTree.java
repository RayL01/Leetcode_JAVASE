package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/05/26/19:37
 * @Description:
 */
public class SecondMinimumNodeInABinaryTree {
  public int findSecondMinimumValue(TreeNode root){
    if(root.left == null && root.right == null) return -1;

    if(root.val == root.left.val){
      root.left.val = findSecondMinimumValue(root.left);
    }
    if(root.val == root.right.val){
      root.right.val = findSecondMinimumValue(root.right);
    }
    if(root.left.val == -1) return root.right.val;
    if(root.right.val == -1) return root.left.val;




    return Math.min(root.left.val, root.right.val);
  }
}
