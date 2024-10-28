import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2024/04/29/21:43
 * @Description:
 */
public class largestRectangleInHistogram {
  public int largestRectangleArea(int[] heights) {
    int maxArea = 0;
    Stack<Pair> stack = new Stack();
    for(int i = 0; i < heights.length; i++){
      int curHeight = heights[i];
      int curIndex = i; //the index of the current element
      while(!stack.isEmpty() && stack.peek().height > curHeight){
        Pair top = stack.pop();
        int width = i - top.index;
        maxArea = Math.max(maxArea, width * top.height);
        //update the index of the current element
        curIndex = top.index;
      }
      //push the current element into the stack
      stack.push(new Pair(curIndex, curHeight));
      //after the loop, there would still be some elements left in the stack
      //we need to calculate the area of the remaining elements

    }
    while(!stack.isEmpty()){
      Pair top = stack.pop();
      int width = heights.length - top.index;
      maxArea = Math.max(maxArea, width * top.height);
    }
    return maxArea;
  }
  class Pair{
    int index;
    int height;
    Pair(int index, int height){
      this.index = index;
      this.height = height;
    }
  }
}
