package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/28/19:31
 * @Description: https://leetcode.com/problems/sum-root-to-leaf-numbers/
 */
public class SumRootToLeafNumbers {
  int res = 0;
  StringBuilder sb = new StringBuilder();
  public int sumNumbers(TreeNode root) {

    traverse(root);
    return res;
  }
  private void traverse(TreeNode root){
    //Set the base case
    if(root == null) return;
    sb.append(root.val);
    if(root.left == null && root.right == null){
        res += Integer.parseInt(sb.toString());
    }

    traverse(root.left);

    traverse(root.right);
    sb.deleteCharAt(sb.length() - 1);

  }
}
