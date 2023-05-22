package com.shady.Trees;
import java.util.LinkedList;
import java.util.Queue;
public class PopulatingNextRightPointersinEachNodeII {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                cur.next = null;
                if(pre != null){
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
        }
        return root;
    }
}
