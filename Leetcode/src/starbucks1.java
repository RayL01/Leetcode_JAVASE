import java.security.cert.CertPathBuilderResult;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/24/21:02
 * @Description:
 */
public class starbucks1 {
  public static int getSpecialSubstring(String s, int k, String charValue) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < charValue.length(); i++) {
      char c = charValue.charAt(i);
      if(c == '0'){
        set.add(((char) ('a' + i)));
      }
    }
    int size = set.size();
    int left = 0;
    int right = 0;
    int curWindowSize = 0;
    //giraffe
    //a, f, g, r
    // k = 2
    int res = 0;
    while(right < s.length()){
      char c = s.charAt(right);
      if(set.contains(c)){
        curWindowSize++;
      }
      right++;
      //update the result;
      res = Math.max(res, right - left);
      //determine whether we should shrink the window size
      while(curWindowSize >= k){
        char x = s.charAt(left);
        left++;
        if(set.contains(x)){
          curWindowSize--;
        }
      }
    }
    return res;

  }
  public static void main(String[] args) {
    // Test Case 0
    String s0 = "giraffe";
    //a,f,g,r
    int k0 = 2;
    String charValue0 = "01111001111111111011111111";
    int result0 = getSpecialSubstring(s0, k0, charValue0);
    System.out.println(result0);  // Expected output: 3

    // Test Case 1
    String s1 = "special";
    int k1 = 1;
    String charValue1 = "00000000000000000000000000";
    int result1 = getSpecialSubstring(s1, k1, charValue1);
    System.out.println(result1);  // Expected output: 1
  }



}
