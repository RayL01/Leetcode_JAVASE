package LinkedList;

public class AddTwoNumbers {


    /**
     * https://leetcode.com/problems/add-two-numbers/description/
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Use two pointers
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int C = carry;
            if(l1 != null){
                C += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                C += l2.val;
                l2 = l2.next;
            }
            //calculate the carrry
            carry = C / 10;

            //calculate the digit at the sum
            C = C % 10;



            cur.next = new ListNode(C);
            cur = cur.next;
        }
        return dummy.next;
    }
}
