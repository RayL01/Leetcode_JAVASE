package com.shady.Trees;

import com.shady.Trees.TreeNode;

import java.util.HashMap;
//Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
public class ConstructBinaryTreefromPreorderandInorderTraversal {
  //Time:O(n) Space:O(n)
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
