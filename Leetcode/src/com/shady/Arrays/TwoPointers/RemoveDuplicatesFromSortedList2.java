package com.shady.Arrays.TwoPointers;

import com.shady.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/20/01:17
 * @Description:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedList2 {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(-1);
    ListNode slow = dummy;
    ListNode fast = head;
    while(fast != null){
      if(fast.next !=null && fast.val == fast.next.val){
        while(fast.next!=null && fast.val == fast.next.val) fast = fast.next;
        fast = fast.next;
        if(fast == null){
          slow.next = null;
        }
      }else {
        slow.next = fast;
        slow = slow.next;
        fast = fast.next;
      }

    }
    return dummy.next;
  }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
