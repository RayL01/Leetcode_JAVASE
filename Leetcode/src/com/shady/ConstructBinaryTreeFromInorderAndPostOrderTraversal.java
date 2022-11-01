package com.shady;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
  class Solution {
    Map<Integer, Integer> ValToIndex = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      for (int i = 0; i < inorder.length; i++) {
        ValToIndex.put(inorder[i], i);
      }
      return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int [] inorder, int inLo, int inHi, int [] postorder, int poLo, int poHi){
      if(inLo > inHi){
        return null;
      }
      int root = postorder[poHi];
      int index = ValToIndex.get(root);
      int leftsize = index - inLo; // get the left size;
      //create the root node
      int rightsize = inHi - index;
      TreeNode treeNode = new TreeNode(root);
      treeNode.left = build(inorder, inLo, index - 1, postorder, poLo, poLo + leftsize -1);
      treeNode.right = build(inorder, index + 1, inHi, postorder, poLo + leftsize, poHi -1 );





      return treeNode;
    }
  }
}
