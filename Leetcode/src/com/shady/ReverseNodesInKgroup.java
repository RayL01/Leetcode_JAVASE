package com.shady;

public class ReverseNodesInKgroup {
  //Time Complexity: O(N) since we process each node exactly twice. Once when we are counting the number of nodes in each recursive call, and then once when we are actually reversing the sub-list. A slightly optimized implementation here could be that we don't count the number of nodes at all and simply reverse k nodes. If at any point we find that we didn't have enough nodes, we can re-reverse the last set of nodes so as to keep the original structure as required by the problem statement. That ways, we can get rid of the extra counting.
  //Space Complexity: O(N/k) used up by the recursion stack. The number of recursion calls is determined by both kk and NN. In every recursive call, we process kk nodes and then make a recursive call to process the rest.
  class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
      //1->2|->3->4|->5->6   k = 2
      // we can use recursion to solve this problem
      // In each sub-group, fist we need to reverse the sub-group,
      // then we should let the head.next point to the return of next recursion
      // In the end, we should return the head of the reversed linked list.
      // there are two base cases, the first one is when the number of elements in the sub-group is less than k
      // then we should directly return the head of the sub-list
      // The 2nd one is when the recursion moves to null(the end of the linked list) it returns null.


      //First of all, we need to set up the base cases for the recursion.

      //we need two nodes as parameters to reverse part of the list.
      ListNode a, b;
      a = b = head;

      if(head == null){
        return null;
      }
      // base case 2, we need to directly return the head of the sub-group if the element in the group is less than k.
      //example: 1->2->3
      //
      int count = 0;

      for (int i = 0; i < k; i++) {
        if(b != null){
          b = b.next;
          count++;
        }
      }
      if(count != k){
        return head;
      }
      //else reverse the sub-list
      //every subproblem contains mainly 3 steps
      //1. reverse the list
      //2. set the next pointer to the header of the reversed list
      //3. return head of the reversed lsit.
      ListNode listHead = reverseList(a, b);
      a.next  = reverseKGroup(b, k);
      return listHead;



    }
    //Since in the previous for loop, we move b to the next node of the last node in the sub-list that requires being reversed
    //the reverse range is [a,b)
    //1->2->3->4->5->6
    //a     |  b
    public ListNode reverseList(ListNode a, ListNode b){
      ListNode pre = null;
      ListNode cur = a;
      while(cur != b){
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
      }
      //return the header of the list
      return pre;

    }
  }
}
