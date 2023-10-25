import org.junit.Test;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/23/21:48
 * @Description:
 */
public class lctest {
  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> -Integer.compare(a, b));
    for(int i = 0; i < nums.length; i++){
      maxHeap.offer(nums[i]);
      if(maxHeap.size() > k){
        maxHeap.poll();
      }
    }
    while(maxHeap.size() > 1){
      maxHeap.poll();
    }
    return maxHeap.peek();
  }
  @Test
  public void test(){
    int k = findKthLargest(new int[]{3,2,1,5,6,4}, 2);

  }
}
