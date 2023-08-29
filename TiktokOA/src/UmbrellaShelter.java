import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/28/17:29
 * @Description:
 */
public class UmbrellaShelter {
  @Test
  public void test(){
    int res = calculateMinimalNumberOfUmbrella(6, new int[]{1, 2, 3, 5, 6});
    System.out.println(res);
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, map.getOrDefault(0, 0) + 1);
  }
  public int calculateMinimalNumberOfUmbrella(int requirement, int[] umbrellas){
    int[] dp = new int[requirement + 1];

    for (int i = 1; i < dp.length; i++) {

      //Since we're gonna take the minimal value after the inner loop, the tmp is initialized as maximum
      int tmp = Integer.MAX_VALUE;
      for (int umbrella: umbrellas
           ) {
        if(i - umbrella < 0){
          //In this case,
          tmp = Math.min(tmp, Integer.MAX_VALUE);
        }else{
          //before we proceed, we should determine whether the previous (i-umbrella) is invalid
          if(dp[i - umbrella] == Integer.MAX_VALUE){
            tmp = Math.min(tmp, Integer.MAX_VALUE);
          }else{
            tmp = Math.min(tmp, dp[i - umbrella] + 1);
          }

        }
      }
      //After this loop, we can assign tmp to dp[i]
      dp[i] = tmp;
    }
    return dp[dp.length - 1] == Integer.MAX_VALUE ? -1 : dp[dp.length - 1];
  }
}
