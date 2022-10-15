package com.shady;

public class PartitionList {
  /**
   * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
   *
   * You should preserve the original relative order of the nodes in each of the two partitions.
   */
  class Solution {
    public ListNode partition(ListNode head, int x) {
      ListNode dummy1 = new ListNode(-1);//virtual node 1
      ListNode dummy2 = new ListNode(-1);//virtual node 2
      ListNode p1 = dummy1;
      ListNode p2 = dummy2;

      ListNode currentPointer = head;//pointer used to traverse the list
      while(currentPointer != null){
        if(currentPointer.val < x){
          p1.next = currentPointer;
          p1 = p1.next;
        }else{
          p2.next = currentPointer;
          p2 = p2.next;
        }
        //to cut off the link from the original list.
        ListNode temp = currentPointer.next;
        currentPointer.next = null;

        currentPointer = temp;
      }
      p1.next = dummy2.next;
      return dummy1.next;
    }
  }
}



