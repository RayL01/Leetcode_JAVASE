import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/07/16:19
 * @Description:
 */
public class workingEffiency {
  @Test
  public void test1(){
    List<Integer> memory = List.of(3, 1, 4, 2);
    System.out.println(maximumProductSum(memory));
    //28
  }
  @Test

  public void test2(){
    List<Integer> memory = List.of(5, 4, 1, 5, 3, 2);
    System.out.println(maximumProductSum(memory));
    //81
  }

  @Test
  public void test3(){
    /**
     * 5, 1, 4, 2, 4, 1, 2, 3
     *
     * 3, 2, 1, 2, 4, 4, 1, 5
     */



    List<Integer> memory = List.of(5, 1, 4, 2, 4, 1, 2, 3);
    System.out.println(maximumProductSum(memory));
  }

  public static int maximumProductSum(List<Integer> memory){
    /**
     * 5, 4, 1, 5, 3, 2
     *
     * 2, 3, 5, 1, 4, 5
     *
     * 2, 4, 1, 5, 3, 5
     *
     * 5, 3, 1, 5, 4, 2
     *
     */
    final int MOD = 1000000007;
    int lo = 0;
    int hi = memory.size() - 1;
    long res = 0L;
    while(lo < hi){//3 1 4 2
      int left = memory.get(lo);
      int right = memory.get(hi);
      if(left <= right){
        res += ((left * (lo + 1)) + (right * (hi + 1)));
        lo++;
        hi--;
      }else{
        res += ((right * (lo + 1) + (left * (hi + 1))));
        lo++;
        hi--;
      }
    }
    res %= MOD;
    return (int) res;
  }
}
