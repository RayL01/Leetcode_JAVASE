package com.shady;
//Given the head of a singly linked list, reverse the list,
// and return the reversed list.
//
//In this particular example, we're using recursion to implement the linked list reversing.
//In order to do this, we need to reach the end of the linked list
//Then how can we do this by recursion?
//We need to call the reverse function until we reach the end of the list
//
//Complexity Analysis
//
//        Time complexity : O(n)O(n). Assume that nn is the list's length, the time complexity is O(n)O(n).
//
//        Space complexity : O(n)O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
public class ReverseLinkedList {
  class Solution {
    public ListNode reverseList(ListNode head) {

      //when the linked list is null, it returns null directly. Otherwise when the recursion reaches the
      //last node in the linked list, it returns the node directly.
      if(head == null || head.next == null){
        return head;
      }
      // get the next node in the linked list
      ListNode PrevNode = reverseList(head.next);
      head.next.next = head;
      head.next = null;

      //In this case, we need to return the PrevNode which points to Node 5
      // So that we get the head pointer in the end
      return PrevNode;
    }
  }
}
