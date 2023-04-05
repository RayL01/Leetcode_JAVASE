package com.shady.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipBinaryTreeToMatchPreorder {

    List<Integer> res = new ArrayList<>();
    int[] voyage;
    int i = 0;
    boolean flippable = true;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.voyage = voyage;

        traverse(root);
        if(flippable){
            return res;
        }
        return Arrays.asList(-1);
    }
    private void traverse(TreeNode root){
        if(root == null || !flippable) return;


        if(root.val != voyage[i++]){
            flippable = false;
            return;
        }

        if(root.left != null && root.left.val != voyage[i]){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            res.add(root.val);
        }
        traverse(root.left);
        traverse(root.right);
    }

}
