package com.shady.Arrays.TwoPointers;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        //Since there are k sorted list, we store the lists into an increasing priority queue to compare them
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) ->  a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for (ListNode list: lists
             ) {
            if(list != null){
                pq.add(list);
            }

        }
        while(!pq.isEmpty()){
            ListNode cur = pq.poll();

            //Put the current head of the list to p.next
            p.next = cur;

            //Then we should push the next node to the priority queue, but be careful since it might be null
            if(cur.next != null){
                pq.add(cur.next);
            }


            //Don't forget to forward the current pointer
            p = p.next;
        }
        return dummy.next;
    }
}
