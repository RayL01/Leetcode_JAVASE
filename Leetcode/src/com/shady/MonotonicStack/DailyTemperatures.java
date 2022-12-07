package com.shady.MonotonicStack;

import org.junit.Test;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/07/00:00
 * @Description: Solve by using monotonic stack
 * https://leetcode.com/problems/daily-temperatures/
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
  public int[] dailyTemperatures(int[] temperatures) {
      //Since we are returning the distance between the given number and its next largest element
      //we
    // just need to push the current index of each element and calculate the difference each time
    Stack<Integer> stack = new Stack<>();
    int[] res = new int[temperatures.length];

    for (int i = temperatures.length - 1; i >= 0 ; i--) {
      while(!stack.empty() && temperatures[i] >= temperatures[stack.peek()]){
        stack.pop();
      }
      res[i] = stack.empty() ? 0 : (stack.peek() - i);
      stack.push(i);

    }
    return res;
  }
  @Test
  public void test(){
    int[] tem = new int[]{73,74,75,71,69,72,76,73};
    for (Integer integer:dailyTemperatures(tem)) {
      System.out.println(integer);
    }

  }
}
