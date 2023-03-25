package LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/25/00:49
 * @Description:
 */
public class ListNode {
  int val;
  ListNode next;
  ListNode(){}
  ListNode(int val){
    this.val = val;
  }
  ListNode(int val, ListNode next){
    this.val = val;
    this.next = next;
  }
}
