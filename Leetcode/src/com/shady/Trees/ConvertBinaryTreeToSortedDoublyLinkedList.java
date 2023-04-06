package com.shady.Trees;

/**
 * https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/description/
 */
public class ConvertBinaryTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;


        //Since we are returning the head of the doubly linked list in the end, so the result of each recursion
        //is the head of the sub-doubly-linked list

        //LeftHead is the head of the linked list at the left
        Node leftHead = treeToDoublyList(root.left);
        //rightHead is the head of the linked list at the right
        Node rightHead = treeToDoublyList(root.right);
        Node leftTail = null;
        Node rightTail = null;

        if(leftHead == null){
            leftTail = leftHead = root;
        }else{
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        }

        if(rightHead == null){
            rightTail = rightHead = root;
        }else{
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        }

        leftHead.left = rightTail;
        rightTail.right = leftHead;
        return leftHead;

    }
}
