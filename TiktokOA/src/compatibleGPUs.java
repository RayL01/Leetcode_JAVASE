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
      int n  = cost.length;

      /**
       * i, j, k
       *
       *
       * i代表选取当前cost数组的前i个元素
       *
       * j代表当前与cluster 1 兼容的数量
       *
       * k代表与当前cluster 2 兼容的数量
       * 最后return dp[n][min_compatible][min_compatible]
       *
       */
      long [][][] dp = new long[n + 1][min_compatible + 1][min_compatible + 1];
      //initialize DP array
      for(int i = 0; i <= n; i++){
        for (int j = 0; j <= min_compatible; j++) {
          for (int k = 0; k <= min_compatible; k++) {
            dp[i][j][k] = Long.MAX_VALUE;
            //we take elements with a MAX_VALUE as invalid elements,
            // namely there's no way of reaching that point of state
          }
        }
      }

      //Set up the base case:代表在不选取任何gpu，
      // 并且现在已有的cluster 1 和cluster 2 的数量为0的情况下，
      // cost的总和为0
      dp[0][0][0] = 0;
      /**
       * 看似好像dp[1][0][0],dp[2][0][0] ... 都等于0
       * 不过其实这个结果通过状态转移方程都是可以得到的
       */
      /**
       * 状态转移方程
       * 1. 假如不拿当前i th GPU:
       * 那么dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k])
       *
       * 2. 假如拿当前i th GPU
       * 那么dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - c1][k - c2] + cost[i - 1]);
       *
       */
      for (int i = 1; i <= n; i++) {
        int c1 = compatible1[i - 1];
        int c2 = compatible2[i - 1];
        for (int j = 0; j <= min_compatible; j++) {
          for (int k = 0; k <= min_compatible; k++) {
            //Don't take the current GPU

            //因为其实[i-1]的invalid的值我们是不应该要的，但是假如我们在这取到了，证明当前也是invalid

            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);




            //Take the current GPU
            //在这种情况下首先需要确保j - c1或者 k - c2 大于等于0
            //比如dp[2][0][0]这种情况因为j - c1是肯定小于零的，这种
            //情况下是不可能take the current cpu的
            if(j - c1 >= 0 && k - c2 >= 0 && dp[i - 1][j - c1][k - c2] != Long.MAX_VALUE){
              //因为这里涉及到加法，假如[i-1]是invalid的话我们就不应该取到他
              //这样的话跟i - 1有联系的i也就变成了invalid
              dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j - c1][k - c2] + cost[i - 1]);
            }
          }
        }
      }
      return dp[n][min_compatible][min_compatible] == Long.MAX_VALUE ? -1 : dp[n][min_compatible][min_compatible];





    }

    public static void main(String[] args) {
      int[] cost = {2, 4, 6, 5};
      int[] compatible1 = {1, 1, 1, 0};
      int[] compatible2 = {0, 0, 1, 1};
      int min_compatible = 2;
      System.out.println(getMinCost(cost, compatible1, compatible2, min_compatible));  // Should print 13
    }




}
