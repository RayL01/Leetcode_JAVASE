package com.shady.Arrays.TwoPointers;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //dummy -> 1 -> 2 -> 3 -> 4 -> 5
        //1 -> 2 -> 3 -> 5
        /**
         * If we want to delete the Nth Node from the end of list
         * we should find the (N+1)th node first.
         */


        //We use a dummy node here since it's possible that we might want to get the 6th node from the end
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node1 = dummy;
        ListNode node2 = dummy;
        for (int i = 0; i < n + 1; i++) {
            node1 = node1.next;
        }

        while(node1 != null){
            node1 = node1.next;
            node2 = node2.next;
        }



        //Now node2 is located at the (N+1)th position from the end.
        node2.next = node2.next.next;
        return dummy.next;

    }
}
