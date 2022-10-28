package com.shady;
//234. Palindrome Linked List
/*Given the head of a singly linked list,return true if it is a palindrome or false otherwise.
        Input: head = [1,2,2,1]
        Output: true*/
//Time: O(n) Space: O(1)
public class PalindromeLinkedList {
  class Solution {
    public boolean isPalindrome(ListNode head) {
      //1->2->3->4->3->2->1

      //In order to determine whether this list is a palindrome, we need to reverse the sub-list indexed after the mid mode in the original list
      // So if we want to reach the middle of the linked list, we can use the fast and slow pointers
      ListNode slow = head, fast = head;
      //1, 2, 3, 2, 1     odd
      //     slow  fast
      //1,   2,   2,   1   null    even
      //         slow      fast
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }
      if (fast != null) {
        slow = slow.next;
      }

      ListNode left = head;
      ListNode right = reverse(slow);
      while (right != null) {
        if (left.val != right.val) {
          return false;
        }
        left = left.next;
        right = right.next;
      }
      return true;

    }

    public ListNode reverse(ListNode head) {
      //1,   2,   2,   1   null    even
      ListNode pre = null;
      ListNode cur = head;
      while (cur != null) {
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
      }
      return pre;

    }
  }
}
