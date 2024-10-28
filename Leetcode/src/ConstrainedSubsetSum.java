import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 *
 *
 * @Description:
 */
public class ConstrainedSubsetSum {
  @Test
  public void test(){
    int res = constrainedSubsetSum(new int[]{-5266, 4019, 7336, -3681, -5767}, 2);
    System.out.println(res);
  }
  public int constrainedSubsetSum(int[] nums, int k) {
    int n = nums.length;
    int[] dp = new int[n];
    MonoQueue mono = new MonoQueue();
    //base case when i = 0
    //add dp[0] into monoQueue
    dp[0] = nums[0];
    mono.push(dp[0]);
    for(int i = 1; i < n; i++){
      int max = mono.max();
      dp[i] = Math.max(nums[i], max + nums[i]);
      if(mono.size() >= k){
        mono.pop();
      }
      mono.push(dp[i]);
    }
    int res = Integer.MIN_VALUE;
    for(int i = 0; i < n; i++){
      res = Math.max(res, dp[i]);
    }
    return res;

  }
  class MonoQueue{
    LinkedList<Integer> list;
    Deque<Integer> mono;
    public MonoQueue(){
      list =  new LinkedList();
      mono = new ArrayDeque();
    }
    public void push(int num){
      while(!mono.isEmpty() && mono.peekLast() < num){
        mono.pollLast();
      }
      //after this loop, we can insert num into the end of the monoQueue;
      mono.addLast(num);
      list.add(num);
    }
    public void pop(){
      int delete = list.getFirst();
      if(delete == mono.getFirst()){
        mono.pollFirst();
      }
      list.pollFirst();
    }
    public int size(){
      return list.size();
    }
    public int max(){
      return mono.peekFirst();
    }
  }
}
