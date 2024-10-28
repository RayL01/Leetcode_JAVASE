import org.junit.Test;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/30/19:36
 * @Description:
 */
public class NumberofVisiblePeopleinaQueue {
  @Test
  public void test(){
    int[] res = canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});

  }
  public int[] canSeePersonsCount(int[] heights) {
    int[] res = new int[heights.length];
    Stack<Integer> stack = new Stack();
    for(int i = res.length - 1; i >= 0; i--){
      int num = heights[i];
      int count = 0;
      while(!stack.isEmpty() && stack.peek() <= num){
        stack.pop();
        count++;
      }
      if(stack.isEmpty()){
        res[i] = count;
        stack.push(heights[i]);
        continue;
      }

      res[i] = count + 1;

      stack.push(heights[i]);
    }
    return res;
  }
}
