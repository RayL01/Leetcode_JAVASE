package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/28/20:36
 * @Description:
 */
public class BinaryTreeLongestConsecutiveSequence {
  int res = 0;
  public int longestConsecutive(TreeNode root) {
    traverse(root, 1, Integer.MAX_VALUE);
    return res;
  }
  private void traverse(TreeNode root, int length, int parentVal){
    if(root == null) return;


    if(root.val == parentVal + 1){
      length++;
    }else{
      //Otherwise, we should reset the length
      length = 1;
    }
    res = Math.max(res, length);
    //And compare the current length with res
    traverse(root.left, length, root.val);
    traverse(root.right, length, root.val);
  }
}
