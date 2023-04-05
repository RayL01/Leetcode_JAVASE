package com.shady.Trees;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //Traverse the tree to generate coordinates
        traverse(root, 0, 0);

        //Then we should sort all the nodes in a specific order
        Collections.sort(nodes, (a, b) -> {
            if(a.column == b.column && a.row == b.row){
                //sort them by root.val
                return a.node.val - b.node.val;
            }

            if(a.column == b.column){
                //sort them by row
                return a.row - b.row;
            }

            //else sort them by column
            return a.column - b.column;
        });

        //After this, we should return the result in the format given by the question
        /**
         * Output: [[9],[3,15],[20],[7]]
         */
        //We should determine whether the current iteration is in the same column as the previous iteration
        LinkedList<List<Integer>> res = new LinkedList<>();
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < nodes.size(); i++) {
            Coordinate cur = nodes.get(i);
            if(cur.column != pre){
                //We should add a new List
                res.add(new ArrayList<>());

                pre = cur.column;
            }
            res.getLast().add(cur.node.val);
        }

        return res;
    }



    //first, we should traverse the whole tree so that we can get the coordinate for each node.
    //Besides, we should store the coordinate into a structure so that we can sort them out.

    List<Coordinate> nodes = new ArrayList<>();
    private void traverse(TreeNode root, int row, int column){

        if(root == null) return;

        nodes.add(new Coordinate(row, column, root));
        traverse(root.left, row + 1, column - 1);
        traverse(root.right, row + 1, column + 1);
    }

    class Coordinate{
        int row;
        int column;
        TreeNode node;
        public Coordinate(int row, int column, TreeNode node){
            this.row = row;
            this.column = column;
            this.node = node;
        }
    }
}
