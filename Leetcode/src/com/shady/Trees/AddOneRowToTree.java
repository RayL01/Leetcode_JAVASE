package com.shady.Trees;

public class AddOneRowToTree {

    private int curDepth = 0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root, depth, val);
        return root;
    }
    private void traverse(TreeNode root, int targetDepth, int val){
        if(root == null) return;

        curDepth++;
        if(curDepth == targetDepth - 1){
            TreeNode newLeft = new TreeNode(val);
            TreeNode newRight = new TreeNode(val);

            newLeft.left = root.left;
            newRight.right = root.right;
            root.left= newLeft;
            root.right = newRight;
        }


        traverse(root.left,targetDepth,val);
        traverse(root.right,targetDepth,val);
    }
}
