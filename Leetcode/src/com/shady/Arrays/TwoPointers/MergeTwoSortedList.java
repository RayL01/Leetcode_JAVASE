package com.shady.Arrays.TwoPointers;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }

        }
        if(l1 == null){
            cur.next = l2;
        }
        if(l2 == null){
            cur.next = l1;
        }
        return dummy.next;

    }
}
