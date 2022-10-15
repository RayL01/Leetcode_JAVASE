package com.shady;

public class MergeTwoSortedLists {

  /**
   * You are given the heads of two sorted linked lists list1 and list2.
   *
   * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
   *
   * Return the head of the merged linked list.
   * Time: O(n+m)
   * Space: O(1)
   */
  class Solution {
    public ListNode mergeTowLists(ListNode l1, ListNode l2) {
      ListNode head1 = l1;
      ListNode head2 = l2;
      // 1, 3, 6
      // 1, 3, 6

      ListNode currentPointer = new ListNode(-100);

      ListNode returnHeader = currentPointer;//used for returning statement


      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          currentPointer.next = l1;
          l1 = l1.next;
        } else {
          currentPointer.next = l2;
          l2 = l2.next;
        }
        //Caution, we need to move the current pointer in each iteration or we can not update
        // the merged linked list
        currentPointer = currentPointer.next;
      }

      currentPointer.next = l1 == null ? l2 : l1;
      return returnHeader.next;
    }
  }
}

