import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/22/14:20
 * @Description:
 */
public class test {
  @Test
  public void test(){
    int res = maxSubarraySumCircular(new int[]{-3,-2,-3});
    System.out.println(res);
    String s = "123 345345 54";
    String[] arr = s.split(" ");
    Stream.of(arr).forEach(System.out::println);
    StringBuilder sb = new StringBuilder();
    sb.append(new String("322432"));
    String x = "1234";
    System.out.println(x + '-');
    System.out.println(x.substring(0,2));

  }
  public int maxSubarraySumCircular(int[] nums) {
    /**.     0   1  2   3  4   5  6
     nums [-3, -2, -3][-3, -2, -3, -2]
     0 1.  2. 3.  4
     prefix[0,-3, -5, -8][-11, -2, 1, -1]
     */
    int n = nums.length;
    int[] prefix = new int[2 * n + 1];
    monotonicStack mono = new monotonicStack();
    for(int i = 1; i < 2 * n + 1; i++){
      prefix[i] = prefix[i - 1] + nums[(i - 1) % n];
    }
    int left = 0;
    int right = 0;
    int res = Integer.MIN_VALUE;
    while(right < 2 * n + 1){

      if(left < right){
        res = Math.max(res, prefix[right] - mono.min());
      }


      while(right - left >= n){
        mono.pop(prefix[left]);
        left++;
      }
      mono.push(prefix[right]);
      right++;

    }
    return res;

  }

  public int shortestSubarray(int[] nums, int k) {
    //first of all, we gotta create a prefix array first
    int n = nums.length;
    int[] prefixSum = new int[n + 1];
    monotonicStack monoStack = new monotonicStack();
    //.       0 1 2 3
    //nums :   1 2 3 4 5
    //pre :0 1 3 6 10 15
    //.    0 1 2 3
    for(int i = 1; i < n + 1; i++){
      prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
    }

    int left = 0;
    int right = 0;
    int res = Integer.MAX_VALUE;
    while(right < n + 1){
      monoStack.push(prefixSum[right]);


      while(prefixSum[right] - monoStack.min() >= k && left < right){
        //update the answer
        int size = right - left;
        res = Math.max(res, size);
        // shrink the size of the monotone stack and the current window
        monoStack.pop(prefixSum[left]);
        left++;

      }
      right++;
    }
    return res  == Integer.MAX_VALUE ? -1 : res;



  }
  public class monotonicStack{
    Deque<Integer> mono = new ArrayDeque();
    public void push(int n){
      while(!mono.isEmpty() && n < mono.peekLast()){
        mono.pollLast();
      }
      mono.addLast(n);
    }
    public int min(){
      return mono.peekFirst();
    }
    public void pop(int n){
      if(mono.peekFirst() == n){
        mono.pollFirst();
      }
    }
  }
}
