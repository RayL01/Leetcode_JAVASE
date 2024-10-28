import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/25/14:46
 * @Description:
 */
public class JumpGame4 {
  @Test
  public void test(){
    int res = maxResult(new int[]{10,-5,-2,4,0,3}, 3);
    System.out.println(res);

  }
  public int maxResult(int[] nums, int k) {
    int n = nums.length;

    //dp[i]: the maximum sum from index 0 to i
    int[] dp = new int[n];
    MonoQueue mono = new MonoQueue();
    //base case
    dp[0] = nums[0];
    mono.push(dp[0]);
    for(int i = 1; i < n; i++){
      int max = mono.max();
      dp[i] = nums[i] + max;
      if(mono.size() == k){
        mono.pop();
      }
      //add the current num into the window
      mono.push(dp[i]);
    }
    return dp[n - 1];

  }
  class MonoQueue{
    Deque<Integer> mono;
    LinkedList<Integer> list;

    public MonoQueue(){
      this.mono = new ArrayDeque();
      this.list = new LinkedList();
    }
    public void push(int num){

      while(!mono.isEmpty() && mono.peekLast() < num){
        mono.pollLast();
      }
      //after this loop, there shouldn't be any number smaller than num coming after it'
      mono.addLast(num);
      list.add(num);
    }
    public int max(){
      return mono.peekFirst();
    }
    public void pop(){
      if(mono.getFirst() == list.get(0)){
        mono.pollFirst();

      }
      list.removeFirst();
    }

    //the size of the current general window(list) is the size for our generic window
    public int size(){
      return list.size();
    }
  }
}
