package com.shady.Trees;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/05/13/16:09
 * @Description:
 */
public class LargestBSTSubtree {
  int res = 0;
  public int largestBSTSubtree(TreeNode root) {
    traverse(root);
    return res;
  }
  private int[] traverse(TreeNode root){
    //return 1.the smallest node in the current root. 2. the largest node in the current root
    //3. the total number of nodes in the current root
    if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

    int [] left = traverse(root.left);
    int[] right = traverse(root.right);
    if(left == null || right == null) return null;

    int leftMin = left[0], leftMax = left[1], leftCount = left[2];
    int rightMin = right[0], rightMax = right[1], rightCount = right[2];

    //Determine whether the current root is a BST
    if(root.val > leftMax && root.val < rightMin){
      leftMin = Math.min(root.val, leftMin);
      rightMax = Math.max(root.val, rightMax);
      int rootCount = 1 + leftCount + rightCount;
      res = Math.max(rootCount, res);
      return new int[]{leftMin, rightMax, rootCount};
    }

    //Not a BST, Then any root contains this sub-tree would be dismissed.
    return null;
  }


}
