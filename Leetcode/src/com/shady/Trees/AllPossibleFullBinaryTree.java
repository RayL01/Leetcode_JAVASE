package com.shady.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossibleFullBinaryTree {
    //Use a memo to avoid duplicated calculation
     List<TreeNode>[] memo;
    public List<TreeNode> allPossibleFBT(int n) {
        //According to the properties of full binary tree, the number of nodes can't be even
        if(n % 2 == 0) return new ArrayList<>();
        memo = new ArrayList[n + 1];
        return build(n);
    }
    private List<TreeNode> build(int n){
        //First set up the base case
        List<TreeNode> res = new ArrayList<>();
        if(memo[n] != null){
            return memo[n];
        }
        if(n  == 1) {
            res.add(new TreeNode(0));
            memo[n] = res;
            return res;
        }

        for (int i = 1; i < n; i = i + 2) {
            int j = n - i - 1;
            List<TreeNode> lefts = build(i);
            List<TreeNode> rights = build(j);

            for (TreeNode left: lefts
                 ) {
                for (TreeNode right: rights
                     ) {
                    TreeNode node  = new TreeNode(0);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        memo[n] = res;
        return res;

    }
}
