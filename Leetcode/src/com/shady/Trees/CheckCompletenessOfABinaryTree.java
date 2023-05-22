package com.shady.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur == null) {
                    flag = true;
                }else{

                    if(flag){
                        return false;
                    }
                    q.offer(cur.left);
                    q.offer(cur.right);
                }

            }
        }
        return true;
    }
}
