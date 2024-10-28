import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/11/17:37
 * @Description:
 */
public class restoreIPAddress {




  StringBuilder sb = new StringBuilder();
  List<String> res = new ArrayList();
  public List<String> restoreIpAddresses(String s) {
    backtrack(s, 0);
    return res;
  }
  private void backtrack(String s, int step){


    if(s.isEmpty()){

      if(step == 4){
//        //delete the dot at the end
//        sb.deleteCharAt(sb.length() - 1);
        StringBuilder tmp = new StringBuilder(sb);
        tmp.deleteCharAt(tmp.length() - 1);
        res.add(tmp.toString());
        return;
      }
      return;
    }



    for(int i = 0; i < 3 && i < s.length(); i++){
      String cur = s.substring(0, i + 1);
      if(isValid(cur)){
        sb.append(cur).append(".");
        backtrack(s.substring(i + 1), step + 1);

        //undo
        int len = cur.length();
        //  "2345 255."
        sb.delete(sb.length() - len - 1, sb.length());
      }
    }
  }
  private boolean isValid(String s){
    int size = s.length();
    if(size > 3){
      return false;
    }else if(s.length() > 1 && s.startsWith("0")){
      return false;
    }else{
      int value = Integer.valueOf(s);
      if(value >= 0 && value <= 255){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Queue queue = new LinkedList();
    String x = "123";
    String s = x.substring(0,0);
    if((x + s).compareTo(x) > 0){
      return;
    }
    List<String> list = new ArrayList<>();
    restoreIPAddress restoreIPAddress = new restoreIPAddress();
    List<String> res = restoreIPAddress.restoreIpAddresses("25525511135");

  }


  @Test
  public void test5(){
    String res = largestNumber(new int[]{10, 2});
    System.out.println(res);
  }
  public String largestNumber(int[] nums) {
    List<String> list = new ArrayList();
    for(int num : nums){
      list.add(String.valueOf(num));
    }
    Collections.sort(list, (a, b) -> {
      if((a + b).compareTo(b + a) > 0){
        return -1;
      }else{
        return 1;
      }
    });
    // 0, 0, 0, 1
    String res = "";
    for(String s: list){
      res += s;
    }
    Queue<Integer> queue = new LinkedList<>();
    Deque deque = new ArrayDeque();
    return String.valueOf(Integer.valueOf(res));
  }
}
