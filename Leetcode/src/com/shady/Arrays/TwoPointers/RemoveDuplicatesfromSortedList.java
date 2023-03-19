package com.shady.Arrays.TwoPointers;

import com.shady.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/12/19:52
 * @Description: Remove duplicates from a sorted linked list
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesfromSortedList {
    class Solution {
      ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
          if (fast.val != slow.val) {
            // nums[slow] = nums[fast];
            slow.next = fast;
            // slow++;
            slow = slow.next;
          }
          // fast++
          fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
      }
    }
}
