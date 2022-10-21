package com.shady;

import java.util.PriorityQueue;

/*You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

        Merge all the linked-lists into one sorted linked-list and return it.*/
//[{1,4,5},{1,3,4},{2,6}]
//Time complexity: O(Nlogk) while N is the number of the linked lists and k is the number of
// all the nodes in the linked lists. Since each time we will pull out one element from
//O(n) Creating a new linked list costs O(n)O(n) space.
//O(k) The code above present applies in-place method which cost O(1) space.
// And the priority queue (often implemented with heaps) costs O(k) space
// (it's far less than NN in most situations).
public class MergeKSortedLists {
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;
      PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->(a.val - b.val));

      if(lists.length == 0){
        return null;
      }
      //Put the head of each list into the priority queue
      for(ListNode h: lists){
        if(h!=null){//null pointer exception
          pq.add(h);
        }

      }
      while(!pq.isEmpty()) {
        ListNode node = pq.poll();
        current.next = node;
        if (node.next != null) {
          pq.add(node.next);
        }
        current = current.next;
      }
      return dummy.next;
    }
  }
}
