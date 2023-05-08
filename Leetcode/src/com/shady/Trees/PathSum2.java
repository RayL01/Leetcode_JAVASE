package com.shady.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum2 {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        traverse(root, targetSum);
        return res;

    }
    private void traverse(TreeNode root, int sum ){
        if (root == null) return;

        int remain = sum - root.val;

        if (root.left == null && root.right == null) {
            if (remain == 0) {
                // 找到一条路径
                path.addLast(root.val);
                res.add(new LinkedList<>(path));
                path.removeLast();
            }
            return;
        }

        // 维护路径列表
        path.addLast(root.val);
        traverse(root.left, remain);
        path.removeLast();

        path.addLast(root.val);
        traverse(root.right, remain);
        path.removeLast();
    }
}
