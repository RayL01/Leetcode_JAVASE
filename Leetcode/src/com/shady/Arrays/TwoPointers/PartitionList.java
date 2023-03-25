package com.shady.Arrays.TwoPointers;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = new ListNode(p.val);
                // p2   dum2 -> 2 -> null
                p2 = p2.next;

                p2.next = null;
            } else {
                //p1  dum1 -> 1 -> null
                p1.next = new ListNode(p.val);
                p1 = p1.next;
                p1.next = null;
            }
            p = p.next;
        }
        // 连接两个链表
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
