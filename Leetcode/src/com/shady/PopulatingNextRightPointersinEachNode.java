package com.shady;
/*You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

        struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
        }
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

        Initially, all next pointers are set to NULL.*/

/*Time: O(n), Space: O(n) since the total calls on stack would be the number of nodes in the tree times 3*/
public class PopulatingNextRightPointersinEachNode {
  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  };
  class Solution {
    public Node connect(Node root) {
      if(root == null){
        return null;
      }
      traverse(root.left,root.right);
      return root;
    }
    void traverse(Node node1, Node node2){
      if(node1 == null || node2 == null){
        return;
      }
      node1.next = node2;

      traverse(node1.left, node1.right);
      traverse(node1.right, node2.left);
      traverse(node2.left,node2.right);
    }
  }
}
