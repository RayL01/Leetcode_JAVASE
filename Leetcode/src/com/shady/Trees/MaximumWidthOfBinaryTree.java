package com.shady.Trees;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    TreeNode node;
    int id;

    public Pair(TreeNode node, int id){
        this.node = node;
        this.id = id;
    }
}
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));


        int left = 0, right = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int curId = cur.id;
                if(i == 0) {
                    left = curId;
                }
                if(i == size - 1){
                    right = curId;
                }
                if(cur.node.left  != null){
                    q.offer(new Pair(cur.node.left, curId * 2));
                }
                if(cur.node.right != null){
                    q.offer(new Pair(cur.node.right, curId * 2 + 1));
                }
            }
            //
            maxWidth = Math.max(maxWidth, right - left  + 1);
        }
        return maxWidth;
    }
}
