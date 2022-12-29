package com.shady.MonotonicQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/11/21:20
 * @Description:
 * https://leetcode.com/problems/sliding-window-maximum/
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum {
  private LinkedList<Integer> queue = new LinkedList<>();//The implementation for the Monotonic Queue
  public class MonotonicQueue{

    /**
     * push a new element into the monotonic queue
     * @param n
     */
    void push(int n){
      while(!queue.isEmpty() && queue.peekLast() < n){
        queue.poll();
      }

      queue.add(n);
    }

    /**
     *
     * @return return the largest element in the monotonic queue
     */
    int max(){
      return queue.peekFirst();
    }


    /**
     * pop out the element at the front of the queue if the element exists
     * @param n
     */
    void pop(int n){
        if(queue.peek() == n){
          queue.poll();
        }
    }
  }
  /**
   * Since the elements in the sliding window follow the first-in-first-out principle and
   * to find the maximum number of queue elements in O(1) time complexity,
   * it is necessary to implement a monotonic queue
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    MonotonicQueue monotonicQueue = new MonotonicQueue();
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      //First, we need to fully fill the sliding window
      if(i < k - 1){
          monotonicQueue.push(nums[i]);
      }else{
        //We go on to push a new element to the queue
        monotonicQueue.push(nums[i]);
        //return the largest element in the current window
        res.add(monotonicQueue.max());
        //Then, we should pop out the element that first comes into the current window

        monotonicQueue.pop(nums[i - k + 1]);

      }

    }
    return res.stream().mapToInt(i -> i).toArray();


  }
  @Test
  public void test(){
    SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
    int[] arr = new int[]{1,3,1,2,0,5};

    int [] arr2 = slidingWindowMaximum.maxSlidingWindow(arr, 3);
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }

  }
}
