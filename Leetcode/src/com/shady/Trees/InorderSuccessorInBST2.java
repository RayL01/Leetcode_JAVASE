package com.shady.Trees;

public class InorderSuccessorInBST2 {

    public Node inorderSuccessor(Node node) {
        Node p = node.right;
        while(p != null && p.left != null){
            p = p.left;
        }
        if(p!=null) return p;


        //otherwise, we have to find its parent node where this node is not its right child
        while(node.parent != null && node == node.parent.right ){
            node = node.parent;
        }
        return node.parent;
    }
}
