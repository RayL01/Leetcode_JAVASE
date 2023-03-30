package com.shady.Trees;

public class PseudoPalindromicPathsInABinaryTree {

    int res = 0;
    int count[] = new int[10];
    public int pseudoPalindromicPaths (TreeNode root) {
        traverse(root);
        return res;
    }
    private void traverse(TreeNode root){
        if(root == null) return;
        count[root.val]++;

        if(root.left == null && root.right == null){
            int odd = 0;
            for (int x:count
                 ) {
                if(x % 2 != 0){
                    odd++;
                }
            }

            if(odd <= 1) res++;
        }


        traverse(root.left);
        traverse(root.right);

        count[root.val]--;
    }
}
