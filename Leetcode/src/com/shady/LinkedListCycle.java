package com.shady;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
  /**
   * Definition for singly-linked list.
   * class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode(int x) {
   *         val = x;
   *         next = null;
   *     }
   * }
   */
  public class Solution {
    /**
     * For this approach, we use a hashset to store the each node, when
     * we traverse the list, we must make sure that current node is not in the set.
     * Time: O(n)
     * Space: O(n)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
      Set<ListNode> nodes = new HashSet<>();
      while(head != null){
        if(nodes.contains(head)){
          return true;
        }
        nodes.add(head);
        head = head.next;
      }
      return false;

    }

    /**
     * Algorithm
     *
     * The space complexity can be reduced to O(1)O(1) by considering two pointers at different speed - a slow pointer and a fast pointer. The slow pointer moves one step at a time while the fast pointer moves two steps at a time.
     *
     * If there is no cycle in the list, the fast pointer will eventually reach the end and we can return false in this case.
     *
     * Now consider a cyclic list and imagine the slow and fast pointers are two runners racing around a circle track.
     * The fast runner will eventually meet the slow runner.
     * Why? Consider this case (we name it case A) - The fast runner is just one step behind the slow runner.
     * In the next iteration, they both increment one and two steps respectively and meet each other.
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head){
      //In this case, the space complexity is O(1) since we don't use the extra space
      if(head == null){
        return false;
      }
      ListNode slow = head;
      ListNode fast = head.next;

      while(slow != fast){
        if(fast == null || fast.next == null){
          return false;
        }
        slow = slow.next;
        fast = fast.next.next;
      }
      return true;
    }
  }

}
