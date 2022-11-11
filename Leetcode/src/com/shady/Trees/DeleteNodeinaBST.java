package com.shady.Trees;

public class DeleteNodeinaBST {
  class Solution {
    /*
    There are 3 possible situations for this problem:
    1. The node to be deleted is a leaf node, so we can directly delete it and return null.
    2. The node to be deleted has only one child, so the child will take its position.
    3. The node to be deleted has both left child and right child, in this case, we have to find an element so that it's larger than the whole left tree but smaller than the whole right sub-tree.
       In order to do this, we have 2 possible solutions. One is to find the smallest element in the right sub-tree, or find the largest element in the left sub-tree. Either way is fine.
       In my approach, we prefer the first one.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
      //First, we should write the base case of the recursion.
      if(root == null){
        return null;
      }

      if(root.val == key){//Got the correct node
        //situation 1, the node has no child
        if(root.left == null && root.right == null){
          return null;
        }

        //situation 2, the node has exactly one child
        if((root.left == null && root.right != null) || (root.right == null && root.left != null)){
          return root.left == null ? root.right : root.left;
        }

        //situation 3, the node has 2 sub-trees
        TreeNode minNode = getMin(root.right);

        //Then we need to delete the minNode in the right sub-tree.
        root.right = deleteNode(root.right, minNode.val);

        minNode.right = root.right;
        minNode.left = root.left;

        //set minNode to be the current root.
        root = minNode;
      }else if(root.val > key){
        root.left = deleteNode(root.left, key);
      }else{//root.val < key
        root.right = deleteNode(root.right, key);
      }


      return root;
    }

    /**
     * return the smallest element in the current root
     * @param p
     * @return
     */
    public TreeNode getMin(TreeNode p){
      while(p.left != null){
        p = p.left;
      }
      return p;
    }
  }
}
