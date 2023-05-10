package com.shady.Trees;

public class CountUnivalueSubtrees {
    int sum = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        traverse(root);
        return sum;
    }
    private int traverse(TreeNode root){
        if(root == null) return -1002;//it means its empty

        int left = traverse(root.left);
        int right = traverse(root.right);
        if(left == -1001 || right == -1001) return -1001;
        if(left == -1002){
            left = root.val;
        }
        if(right == -1002){
            right = root.val;
        }

        if(left == right && root.val == left){
            sum++;
            return root.val;
        }
        //else it means that the current subtree is not a univalue tree
        return -1001;
    }
}
