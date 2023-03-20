package com.shady.Arrays.TwoPointers;

import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/20/01:55
 * @Description:
 */
public class RemoveDuplicatesFromanUnsortedLinkedList {
  public ListNode deleteDuplicatesUnsorted(ListNode head) {
    //1 2 5 4 3 4 5 2 |6| 3 4 5
    HashMap<Integer, Integer> map = new HashMap<>();
    ListNode p = head;

    //get the count for each number in the unsorted list
    while(p != null){
      map.put(p.val,map.getOrDefault(p.val, 0) + 1);
      p = p.next;
    }
    ListNode dummy = new ListNode(-1);
    ListNode slow = dummy;
    ListNode fast = head;
    while (fast != null){
      if(map.get(fast.val) > 1){
        fast = fast.next;
        if(fast == null){
          slow.next = fast;
        }
      } else{
        slow.next = fast;
        slow = slow.next;
        fast = fast.next;
      }
    }
    return dummy.next;
  }
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
