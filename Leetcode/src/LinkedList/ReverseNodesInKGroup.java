package LinkedList;

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        //set up the base case
        if(head == null) return null;

        //And we should check whether the length of the current sub-group is larger than or equal to k
        ListNode a = head; ListNode b = head;
        for (int i = 0; i < k; i++) {
            if(b == null) return head;
            b = b.next;
        }
        //After the detection, we can reverse the current sub-group;
        ListNode newNode = reverse(a, b);
        head.next = reverseKGroup(b,k);
        return newNode;
    }
    private ListNode reverse(ListNode a, ListNode b){
        ListNode pre ;
        ListNode cur ;
        ListNode next;
        pre = null; cur = a; next = a;

        while(cur != b){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
