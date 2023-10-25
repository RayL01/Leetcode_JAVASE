import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/16/23:16
 * @Description:
 */
public class queries {
  public static ArrayList<Integer> solution(int[] a, int[] b, int[][] queries) {
    ArrayList<Integer> result = new ArrayList<>();

    // HashMap to store the frequency of each element in array a
    HashMap<Integer, Integer> aCounter = new HashMap<>();
    for (int num : a) {
      aCounter.put(num, aCounter.getOrDefault(num, 0) + 1);
    }

    // Process each query
    for (int[] query : queries) {
      if (query[0] == 0) {
        // Update the element in array b
        int i = query[1];
        int x = query[2];
        b[i] += x;
      } else {
        // Find the total number of pairs (i, j) such that a[i] + b[j] = x
        int x = query[1];
        int count = 0;
        for (int y : b) {
          count += aCounter.getOrDefault(x - y, 0);
        }
        result.add(count);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3};
    int[] b = {1, 4};
    int[][] queries = {{1, 5}, {0, 0, 2}, {1, 5}};

    ArrayList<Integer> output = solution(a, b, queries);
    System.out.println(output);  // Output should be [1, 2]
  }
}
