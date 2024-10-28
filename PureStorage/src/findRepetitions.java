import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/10/17:25
 * @Description:
 */
public class findRepetitions {


  /**
   *
   * @param short_s
   * @param long_s
   * @return
   *          01
   * short = "AB"
   *               6789
   * long = "ABCABCABAB
   *
   */

  public static int read_and_find_repetitions(String short_s, String long_s){
    int res = 0;
    int long_index = 0;
    int m = long_s.length();
    int n = short_s.length();
    if(short_s.isEmpty()){
      return 0;
    }
    if(n > m) return 0;
    for (int i = 0; i < m; ) {
      if(long_s.charAt(i) == short_s.charAt(0)){
        long_index = i;
        int count = 0;
        while(long_index < m && long_s.charAt(long_index) == short_s.charAt((long_index - i) % n)){
          if((long_index - i + 1) % n == 0){
            count++;
          }
          long_index++;
        }
        res = Math.max(res, count);
        i = long_index;
      }else{
        i++;
      }
    }
    return res;
  }
  @Test
  public void test1(){
    System.out.println(read_and_find_repetitions("", "BB"));
  }
}
