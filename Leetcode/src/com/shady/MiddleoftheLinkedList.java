package com.shady;

public class MiddleoftheLinkedList {
  class Solution {
    /**
     * The core idea for this algorithm is that we can set 2 pointers, the fast one runs twice faster than the
     * slower one, therefore, when the slower one reaches the mid point, the faster one reaches the end.
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
      ListNode slow = head, fast = head;
      while(fast != null && fast.next != null){// && means once when one condition meets, the loop will terminate
        fast = fast.next.next;
        slow = slow.next;
      }
      return slow;
    }
  }
}
