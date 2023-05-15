package com.shady.Trees;

public class BinaryTreeLongestConsecutiveSequence {
    int res = 0;

    public int longestConsecutive(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * left:   递减， 递增
     *
     * right: 递减， 递增
     */

    private int []  traverse(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int leftAscend = left[0], leftDescend = left[1];
        int rightAscend = right[0], rightDescend = right[1];
        int ascendInc = 1, descendInc = 1;
        if(root.left != null){
            if(root.left.val == root.val + 1){
                //Ascending  order
                ascendInc += leftAscend;
            }else if(root.left.val == root.val - 1){
                descendInc += leftDescend;
            }
        }

        if(root.right != null){
            if(root.right.val == root.val + 1){
                ascendInc = Math.max(ascendInc, rightAscend + 1);
            }else if(root.right.val == root.val -1){
                descendInc = Math.max(descendInc, rightDescend + 1);
            }
        }

        //update the result
        res = Math.max(res, ascendInc + descendInc - 1);


        return new int[]{ascendInc, descendInc};


    }
}
