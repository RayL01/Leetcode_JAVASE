package com.shady.Arrays.TwoPointers;

import com.shady.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {
  /**
   * Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
   *
   * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.
   *
   * Do not modify the linked list.
   * Input: head = [3,2,0,-4], pos = 1
   * Output: tail connects to node index 1
   * Explanation: There is a cycle in the linked list, where tail connects to the second node.
   * Space: O(n)
   * Time: O(n)
   * @param head
   * @return
   */
  public com.shady.ListNode detectCycle(com.shady.ListNode head) {
    Set<com.shady.ListNode> visited = new HashSet<>();
    ListNode node = head;
    while(node != null){
      if(visited.contains(node)){
        return node;
      }
      visited.add(node);
      node = node.next;
    }
    return null;
  }
}
