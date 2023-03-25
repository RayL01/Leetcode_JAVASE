package com.shady.Arrays.TwoPointers;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseLinkedList {


    /**
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        /**
         * 1 -> 2 -> 3 -> 4 -> 5
         * we should return the last node and if we want to return it, we must iterate through the list to reach the last node
         */

        //First of all, write the base case for the recursion \
        if(head == null || head.next == null){
            return head;
        }
        //Then we analyze the second node from end of the list.
        ListNode node = reverseList(head.next);


        //head.next is '5' and 5.next is the current node('4')
        head.next.next = head;

        //Then we should set currentnode.next to null
        head.next = null;

        return node;

    }
}
