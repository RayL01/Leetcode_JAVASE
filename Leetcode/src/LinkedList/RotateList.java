package LinkedList;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        //k =2
        //1 -> 2 -> 3 -> 4 -> 5
        //First we should get the total length of the list
        //1 -> 2 -> 3 -> 4 -> 5 -> 1
        // 1 -> 2 -> 3   |  -> null    4 -> 5 -> 1 -> 2 -> 3

        ListNode head1 = head;
        int length = 0;
        while(head1.next != null){
            head1 = head1.next;
            length++;
        }
        length++;
        //After this, point head1.next to the current head
        head1.next = head;
        ListNode head2 = head;
        for (int i = length - k % length; i > 1; i--) {
            head2 = head2.next;
        }

        //Now head2 is pointing at '3'
        //we should poimt '3'.next to null and set '4' as the head
        ListNode newHead = head2.next;

        head2.next = null;
        return newHead;
    }
}
