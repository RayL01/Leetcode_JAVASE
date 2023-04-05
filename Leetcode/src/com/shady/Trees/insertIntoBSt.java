package com.shady.Trees;

public class insertIntoBSt {
    TreeNode insertBST(TreeNode root, int val){
        if(root == null) return new TreeNode(val);

        if(root.val < val){
            root.right = insertBST(root.right, val);
        }
        if(root.val > val){
            root.left = insertBST(root.left, val);
        }
        return root;
    }
}
