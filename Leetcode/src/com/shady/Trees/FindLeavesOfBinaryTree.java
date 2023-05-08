package com.shady.Trees;

/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/description/
 */

import java.util.ArrayList;
import java.util.List;

/**
 * To solve this problem, we should find the heights of all the nodes from the leaf nodes.
 * And add the nodes with the same height to the result arraylist.
 */
public class FindLeavesOfBinaryTree {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        traverse(root);
        return res;
    }
    private int traverse(TreeNode root){
        //First we should use postorder traversal to get the height from the leaf node for each node in the tree
        if(root == null) return  0;


        int height = Math.max(traverse(root.left), traverse(root.right)) + 1;

        //And now we since we can initialize an arraylist to store all nodes in the current height
        //but first we should determine whether the current position has been initialized or not.
        if(res.size() < height){
            res.add(new ArrayList<>());
        }

        //Then we could add the node at the current height to the result arraylist
        res.get(height - 1).add(root.val);

        return height;
    }
}
