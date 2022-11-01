package com.shady;

import java.util.HashMap;

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
    HashMap<Integer, Integer>ValToIndex = new HashMap<>();//store the mapping from value to index in the inorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      for (int i = 0; i < inorder.length; i++) {
        ValToIndex.put(inorder[i], i);
      }



      return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode build(int preorder[], int prelo, int prehi, int inorder[], int inlo, int inhi){
      //base case
      if(prelo > prehi){
        return null;
      }

      int root = preorder[prelo];
      int index = ValToIndex.get(root);
      int leftsize = index - inlo; // get the left size;
      //create the root node

      TreeNode treeNode = new TreeNode(root);
      treeNode.left = build(preorder, prelo + 1, prelo + leftsize, inorder, inlo, index - 1);
      treeNode.right = build(preorder, prelo + leftsize + 1, prehi, inorder, index + 1, inhi);
      //call the left and right recursion



      return treeNode;
    }
  }
}
