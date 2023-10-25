import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
//    int res = maximumPrioritySum(3, new int[]{3, 1, 2}, 5, 7);
//    System.out.println(res);
  }

  public static class Task {
    int priority;
    int nextAvailableTime;

    public Task(int priority, int nextAvailableTime) {
      this.priority = priority;
      this.nextAvailableTime = nextAvailableTime;
    }
  }

  public static int maximumPrioritySum(List<Integer> priority, int x, int y) {
    PriorityQueue<Task> maxPriority = new PriorityQueue<>((a, b) -> Integer.compare(a.nextAvailableTime, b.nextAvailableTime));
    PriorityQueue<Task> maxHeap = new PriorityQueue<>((a, b) -> -Integer.compare(a.priority, b.priority));

    for (int p : priority) {
      Task newTask = new Task(p, 0);
      maxPriority.add(newTask);
      maxHeap.add(newTask);
    }

    int sum = 0;
    for (int t = 1; t <= y; t++) {
      while (!maxPriority.isEmpty() && maxPriority.peek().nextAvailableTime <= t) {
        Task task = maxPriority.poll();
        maxHeap.add(task);
      }

      if (!maxHeap.isEmpty()) {
        Task task = maxHeap.poll();
        sum += task.priority;
        task.nextAvailableTime = t + x;
        maxPriority.add(task);
      }
    }
    return sum;
  }

}
