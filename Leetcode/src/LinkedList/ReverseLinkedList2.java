package LinkedList;

import com.shady.EncodeAndDecode;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/25/00:48
 * @Description:
 */
public class ReverseLinkedList2 {
  ListNode node = null;
  public ListNode reverseBetween(ListNode head, int left, int right) {
    /**
     *  1 -> 2 -> | 3 -> 4 -> 5 | -> 6 -> 7 -> 8
     *  1 -> 2 -> | 5 -> 4 -> 3 | -> 6 -> 7 -> 8
     */

    //when left == 1, we just need to reverse the first k nodes of the linked list
    //When left is larger than 1, we just set the next as the next node as usual
    if(left > 1){
      head.next = reverseBetween(head.next,left - 1, right - 1);
    }else{//it's pretty much like the base case
      return reverse(head, right);
    }
    return head;

  }

  /**
   * reverse the first k nodes from the head node
   * @param head
   * @return
   */
  public ListNode reverse(ListNode head, int k){
    /**
     *  | 3 -> 4 -> 5 | -> 6 -> 7 -> 8
     *  | 5 -> 4 -> 3 | -> 6 -> 7 -> 8
     */
    //Since we are returning the last node as the head of the reversed linked list, we should traverse though till the end of the list

    //And we should return the last node as the base case
    if(k == 1){
      //Set up the base case
      node = head.next;

      return head;
      //And we should retrieve the next node



    }
    //And we should take the second node from end of the list as a template for the recursion
    ListNode header = reverse(head.next, k - 1);


    //'head.next.next' is the last node's next node, supposing now the recursion is at the second node from end of the list
    //And we set last node's next to the current node
    head.next.next = head;

    //Then we set the current node's next to 'node'
    head.next = node;

    return header;
  }
}
