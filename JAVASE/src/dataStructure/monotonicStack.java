package dataStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/21/15:05
 * @Description:
 */
public class monotonicStack {
  LinkedList<Integer> list = new LinkedList<>();

  Deque<Integer> max = new ArrayDeque<>();
  Deque<Integer> min = new ArrayDeque<>();
  public void push(int n){
    list.add(n);
    while(!max.isEmpty() && n > max.peekLast()){
      max.pollLast();
    }
    max.addLast(n);

    while(!min.isEmpty() && n < min.peekLast()){
      min.pollLast();
    }
    min.addLast(n);
  }
  public int max(){
    return max.peekFirst();
  }
  public int min(){
    return min.peekFirst();
  }
  public void pop(){
    int delete = list.pollFirst();
    if (delete == max.peekFirst()){
      max.pollFirst();
    }
    if(delete == min.peekFirst()){
      min.pollFirst();
    }
  }

}
