package com.shady.Trees;

import com.sun.source.tree.Tree;

public class SmallestStringStartingFromLeaf {
    String res = null;
    StringBuilder path = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root) {
        if (root == null) return;

        path.append((char) ('a' + root.val));

        if (root.left == null && root.right == null) {
            path.reverse();
            String s = new String(path);
            if (res == null || res.compareTo(s) > 0) {
                res = s;

            }

            //after that, don't forget to restore the string to its original state
            path.reverse();
        }

        traverse(root.left);

        traverse(root.right);

        path.deleteCharAt(path.length() - 1);
    }




}




