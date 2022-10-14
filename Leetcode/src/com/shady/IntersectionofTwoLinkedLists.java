package com.shady;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 */
public class IntersectionofTwoLinkedLists {
  public class Solution {
    /**
     * We use hashmap to store all elements of one linkedlist, and traverse the other
     * and examine whether the current node is in the hashset
     * Time(N+M)
     * Space: O(M)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      Set<ListNode> set = new HashSet<>();
      ListNode nodeA = headA;
      ListNode nodeB = headB;

      //add all elements of List A into the set
      while(nodeA != null){
        set.add(nodeA);
        nodeA = nodeA.next;
      }

      while(nodeB != null){
        if(set.contains(nodeB)){
          return nodeB;
        }
        nodeB = nodeB.next;
      }
      return null;
    }
  }
}
