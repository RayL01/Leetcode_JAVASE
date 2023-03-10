package com.shady.Graph.BFS;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        //base case
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.poll();
                //determine whether the destination has been reached
                if(treeNode.left == null && treeNode.right == null){
                    return depth;
                }
                if(treeNode.left != null) q.offer(treeNode.left);
                if(treeNode.right != null) q.offer(treeNode.right);
            }
            depth++;
        }
        return 0;

    }

}

class TreeNode {
     int val;
     TreeNode left;
   TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
        this.left = left;
       this.right = right;
    }
 }

