package com.shady.Trees;

public class ConvertBSTtoGreaterTree {

  class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
      traverse(root);
      return root;
    }
    public void traverse(TreeNode root){//Since the value of the current node equals the value of the node itself and the total value of the right subtree. And the value of the left-subtree  equals the value it self plus the value of the current node.
        if(root == null){
          return;
        }
        traverse(root.right);
        sum += root.val;
        //And update the new value of current node
        root.val = sum;
        traverse(root.left);

    }
  }
}
