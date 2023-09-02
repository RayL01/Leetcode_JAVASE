import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/30/00:27
 * @Description:
 */
public class compatibleGPUs {



    public static long getMinCost(int[] cost, int[] compatible1, int[] compatible2, int min_compatible) {
      return backtrack(cost, compatible1, compatible2, min_compatible, 0, 0, 0, 0);
    }
  public static void main(String[] args) {
    int[] cost = { 2, 4, 6, 5 };
    int[] compatible1 = { 1, 1, 1, 0 };
    int[] compatible2 = { 0, 0, 1, 1 };
    int min_compatible = 2;

    System.out.println(getMinCost(cost, compatible1, compatible2, min_compatible));
  }

    public static long backtrack(int[] cost, int[] compatible1, int[] compatible2, int min_compatible,
                                 int index, int cluster1Count, int cluster2Count, long totalCost) {
      if (cluster1Count >= min_compatible && cluster2Count >= min_compatible) {
        return totalCost;
      }
      if (index == cost.length) {
        return -1;
      }

      // Option 1: Do not include the current GPU by just skipping it
      long option1 = backtrack(cost, compatible1, compatible2, min_compatible, index + 1, cluster1Count, cluster2Count, totalCost);

      // Option 2: Include the current GPU by choosing it(
      long option2 = backtrack(cost, compatible1, compatible2, min_compatible, index + 1,
              cluster1Count + compatible1[index], cluster2Count + compatible2[index], totalCost + cost[index]);

      // Take the minimum of the two options, excluding any -1s
      if (option1 == -1) return option2;
      if (option2 == -1) return option1;
      return Math.min(option1, option2);
    }



}
