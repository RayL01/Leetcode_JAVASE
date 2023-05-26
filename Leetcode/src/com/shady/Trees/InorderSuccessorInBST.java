package com.shady.Trees;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        if(root == null) return null;
        TreeNode successor = null;
        if(root.val > p.val){
            successor = inorderSuccessor(root.left, p);
            if(successor == null){
                successor = root;
            }
        }
        if(root.val < p.val){
            successor = inorderSuccessor(root.right,p);
        }
        if(root.val == p.val){
            successor = getMin(root.right);
        }
        return successor;
    }
    private TreeNode getMin(TreeNode node){
        if(node == null) return null;
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
