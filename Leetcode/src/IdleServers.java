import java.util.Arrays;
import java.util.Comparator;

public class IdleServers {


  public class MinimumCostServers {

    public static int minimumCost(int[] data, int k) {

      int n = data.length;
      Arrays.sort(data);

      int sum = 0;
      for (int i = 0; i < n / 2; i++) {
        sum += data[n - i - 1];
      }
      if (sum < k) {
        return -1;
      }

      int l = 0;
      int r = n / 2;

      while (l < r) {
        int mid = (l + r) / 2;
        if (check(data, mid, k)) {
          r = mid;
        } else {
          l = mid + 1;
        }
      }

      return l;
    }

    private static boolean check(int[] data, int mid, int k) {
      int s = 0;
      int n = data.length;

      for (int i = 0; i < mid; i++) {
        s += data[n - i - 1];
      }
      for (int i = mid; i < n/2 - mid; i++) {
        s += data[i];
      }

      return s >= k;
    }
  }

}
