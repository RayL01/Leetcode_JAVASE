import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/29/21:08
 * @Description:
 */
public class MaximizingTaskPriority {
  @Test
  public void test(){
    int res = getMaxPrioritySum(3, new int[]{3, 1, 2}, 5, 7);
    System.out.println(res);
  }

  public static class Task {
    int priority;
    int nextAvailableTime;

    public Task(int priority, int nextAvailableTime) {
      this.priority = priority;
      this.nextAvailableTime = nextAvailableTime;
    }
  }

  public static int getMaxPrioritySum(int n, int[] priority, int x, int y) {
    // Max heap to keep track of highest priority tasks
    PriorityQueue<Task> maxPriority = new PriorityQueue<Task>((a, b) -> {
      if(a.nextAvailableTime == b.nextAvailableTime){
        //in this case, we sort the queue by priority in descending order
        return -Integer.compare(a.priority, b.priority);
      }else{
        return Integer.compare(a.nextAvailableTime, b.nextAvailableTime);
      }
    });

    //we initialize each task object with original value = 0 for the time
    for (int p : priority) {
      maxPriority.add(new Task(p, 0));
    }

    int sum = 0;
    for (int t = 1; t <= y; t++) {
      Task task = maxPriority.peek();
      //now we check whether the time is smaller than the current time 't'
      int time = task.nextAvailableTime;
      if(time > t){
        continue;
      }else{
        //pop up the task from pq and update its next time and put it back to the queue
        maxPriority.poll();
        int curPriority = task.priority;

        //update sum
        sum += curPriority;
        maxPriority.add(new Task(curPriority, t + x));
      }

    }
    return sum;
  }
}
