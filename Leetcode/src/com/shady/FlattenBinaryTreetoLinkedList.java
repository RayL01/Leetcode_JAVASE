package com.shady;

public class FlattenBinaryTreetoLinkedList {
  //Given the root of a binary tree, flatten the tree into a "linked list":
  //
  //The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
  //The "linked list" should be in the same order as a pre-order traversal of the binary tree.
  //Recursion: TIme: O(n) Space:O(n)
  class Solution {
    public void flatten(TreeNode root) {

//         1
//        / \
//      2     5
//     / \     \
//    3   4     6
      // In order to flatten the tree, we just need to move the left sub-tree to the right of the root, and set root.left as null, then move the right of the sub tree to the right of the originally left subtree.
      // In this case, we can see that every step is pretty much the same as what is stated above, so we just need to duplicate the process into a recursion.

      if(root == null){//base case
        return;
      }
      flatten(root.left);
      flatten(root.right);

      TreeNode right = root.right;
      root.right = root.left;
      root.left = null;

      TreeNode p = root;
      while(p.right!=null){
        p = p.right;
      }
      p.right = right;


    }
  }
}
