import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/29/12:29
 * @Description:
 */
public class divideArrayIntoSubarrayWithSumNoGreaterThanM {


  @Test public void test(){
    int res = count(new int[]{4, 5, 6, 1, 9, 6, 2}, 11);
    System.out.println(res);
  }
  /**
   * Divide an array into subarrays with sum nogreater than M, minimize the sum of max value from each division
   * @param
   * @param M
   * @return
   */
  public int count(int[] arr, int M){
    int [] dp = new int[arr.length];
    dp[0] = arr[0];


    int[] prefix = new int[arr.length + 1];
    for (int i = 1; i < prefix.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i - 1];
    }
    for (int i = 1; i < dp.length; i++) {
      int res = Integer.MAX_VALUE;
      for (int k = i; k >= 0; k--) {
        int sum = 0; // since we want to make sure that sum of the current subarray is not greater than M
        sum = prefix[i + 1] - prefix[i - k];
        int currentMaxValue = 0;
        if(sum > M) continue;
        if(k == i){
          //in this case i - k - 1 < 0 so dp[i - k - 1] will just be 0
          int max = findMaxValue(arr, 0, i);
          res = Math.min(res, max);

        }else{
          //since i - k - 1 is not negative, we find the max value starting at index i - k
          //dp[i - k - 1] is the previous minimal value; and starting from index i - k is the current interval for finding the minimal value
          //And we add dp[i - k - 1] & current max value in the interval [i-k, i]
          int max = findMaxValue(arr, i - k, i);
          res = Math.min(res, dp[i - k -1] + max);
        }
      }
      dp[i] = res;
    }
    return dp[arr.length -1];
  }
  int findMaxValue(int arr[], int start, int end){
    int res = 0;
    for (int i = start; i <= end; i++) {
      res = Math.max(res, arr[i]);
    }
    return res;
  }
}
