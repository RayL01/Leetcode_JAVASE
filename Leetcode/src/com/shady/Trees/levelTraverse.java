package com.shady.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelTraverse {
  public static void main(String[] args) {
    TreeNode node6 = new TreeNode(2);
    TreeNode node7 = new TreeNode(3);
    TreeNode node1 = new TreeNode(6, node6, node7);

    TreeNode node3  = new TreeNode(-6);
    TreeNode node5  = new TreeNode(2);
    TreeNode node4  = new TreeNode(2,node5, null);
    TreeNode node2 = new TreeNode(-3, node3, node4);
    TreeNode root = new TreeNode(9, node1, node2);
    levelTraverse.levelTravesal(root);
  }
  public  static void levelTravesal(TreeNode root){
    if(root == null){
      return;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      TreeNode cur = q.poll();

      System.out.println(cur.val);

      if (cur.left != null) {
        q.offer(cur.left);
      }
      if (cur.right != null) {
        q.offer(cur.right);
      }
    }
  }
}
