package com.shady;

/**
 * One pass algorithm
 * The above algorithm could be optimized to one pass. Instead of one pointer, we could use two pointers. The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list. Now, both pointers are exactly separated by nn nodes apart. We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. The second pointer will be pointing at the nnth node counting from the last. We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
 * Space: O(1)
 * Time:O(n)
 */
public class RemoveNthNodeFromEndofList {
  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
      //we set two pointers for this one pass algorithm
      //if we want to delete the kth from end of the list, we have to find
      //the k - 1 th node from end of the list.

      ListNode beforeHead = new ListNode(0);
      beforeHead.next = head;
      ListNode p1 = beforeHead;
      ListNode p2 = beforeHead;
      for (int i = 0; i < n + 1; i++) {
        p1 = p1.next;

      }
      while (p1 != null) {
        p1 = p1.next;
        p2 = p2.next;
      }
      //now we get the reference for the target k - 1 th node, but
      //there's one exception, if we want to delete the head node,
      // it's not doable since there's no nodes before it, so we have
      // to create a node before the head pointer.
      p2.next = p2.next.next;
      return beforeHead.next;

    }
  }
}



