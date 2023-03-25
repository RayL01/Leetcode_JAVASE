package com.shady.Arrays.TwoPointers;

public class FindingTheKthElementFromTheEnd {
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }

        ListNode cur = head;
        while(p != null){
            cur = cur.next;
            p = p.next;
        }
        return cur;

    }

}
