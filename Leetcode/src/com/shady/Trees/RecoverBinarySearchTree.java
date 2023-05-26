package com.shady.Trees;

public class RecoverBinarySearchTree {
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode first = null, second = null;
    public void recoverTree(TreeNode root) {
        traverse(root);

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void traverse(TreeNode root){
        if(root == null) return;

        traverse(root.left);
        /**
         * in order traversal position
         */
        if(root.val < pre.val){
            if(first == null){
                first = pre;
            }
            second = root;
        }
        pre = root;
        traverse(root.right);
    }
}
