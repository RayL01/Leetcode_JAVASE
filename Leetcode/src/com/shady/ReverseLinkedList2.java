package com.shady;

public class ReverseLinkedList2 {
  //Time Complexity: O(N) considering the list consists of NN nodes. We process each of the nodes at most once (we don't process the nodes after the n^{th}n

  //  node from the beginning.
  //Space Complexity: O(1) since we simply adjust some pointers in the original linked list and only use O(1) additional memory for achieving the final result.
  class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
      ListNode pre = null;
      ListNode cur = head;
      while(left > 1){
        pre = cur;
        cur = cur.next;
        left -- ;
        right --;
      }
      //7->9 | ->8->1->10->2 | ->6
      // in order to link the reversed listed to the nodes at both ends
      // we need to store the pre pointer at the beginning.

      ListNode pre2 = null;
      while(right > 0){
        ListNode nextNode = cur.next;
        cur.next = pre2;
        pre2 = cur;
        cur = nextNode;
        right --;
      }
      // point prev.next to prev2, point prev.next.next to cur
      //example: 1->2->3｜-> 4 -> 5  6->7->8
      //           pre       pre2 cur
      if(pre != null){
        ListNode tmp = pre.next;
        pre.next = pre2;
        tmp.next = cur;

      }else{
        //example  |1 <- 2 <- 3| -> 4 -> 5
        //    prev head      prev2  cur
        head.next = cur;
        head = pre2;
      }
      //3<-5|4->->6->8

      return head;
    }
  }
}
