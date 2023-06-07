package com.shady.Trees;

import com.shady.ListNode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/06/07/13:49
 * @Description:
 */
public class ConvertSortedListtoBinarySearchTree {
  public TreeNode sortedListToBST(ListNode head) {
    return traverse(head, null);
  }
  TreeNode traverse(ListNode begin, ListNode end){
    if(begin == end) return null;
    ListNode mid = getMid(begin, end);
    TreeNode root = new TreeNode(mid.val);
    root.left = traverse(begin, mid);
    root.right = traverse(mid.next, end);

    return root;
  }
  //1 -> 2 -> 3 -> 4 -> 5 -> null
  ListNode getMid(ListNode begin, ListNode end){
    ListNode slow = begin;
    ListNode fast = begin;
    while(fast != end || fast.next != end){
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

}
