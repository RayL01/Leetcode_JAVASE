package LinkedList;

public class SwapNodeInPairs {


    /**
     * https://leetcode.com/problems/swap-nodes-in-pairs/
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        //First of all, let's break it down into a sub-problem
        //We can find that each sub-problem is pretty much the same -- reverse the current pair and point the next of the trail to next sub-problem
        //Therefore, we can solve it by recursion

        //Here's the base case;
        if(head.next == null || head == null){
            return head;
        }

        //Then, we should reverse the current pair by recursion
        ListNode left = head;
        ListNode right = head.next;

        //left.next should be the head of next recursion
        left.next = swapPairs(right.next);
        right.next = left;



        //Finally, we should return the head of the current sub-list;
        return right;

        // 1 2 3 4
        // 2 1 3 4
        // 2 3 1 4
        // 2 3 4 1
    }
}
