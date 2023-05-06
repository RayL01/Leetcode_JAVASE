package com.shady.Trees;

public class FlipEquivalentBinaryTree {
//    https://leetcode.com/problems/flip-equivalent-binary-trees/
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;

        //Scenario1 : We don't flip the current sub trees;  Scenario2: we do flip the sub-trees
        return (flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right,root2.left));




    }
}
