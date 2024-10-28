import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/18/23:39
 * @Description:
 */
public class BasicCalculator {
  @Test
  public void test(){
    StringBuilder sb = new StringBuilder();
    int res = calculate("3+2*2");
    System.out.println(res);
    String s = "133";
    Thread t = new Thread();
  }
  public int calculate(String s) {
    Stack<Integer> stack = new Stack();
    char sign = '+';
    int num = 0;
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)){
        num = 10 * num + (c - '0');
      }

      //1 * 2 + 3
      if(!Character.isDigit(c) && c != ' '|| i == s.length() - 1){



        if(sign == '+'){//be careful, it should be 'sign' instead of c here
          stack.push(num);
        }else if(sign == '-'){
          stack.push(num);
        }else if(sign == '*'){
          int left = stack.pop();
          stack.push(left * num);
        }else{
          int left = stack.pop();
          stack.push(left / num);
        }
        num = 0;
        sign = c;
      }
    }
    int res = 0;
    for(int i : stack){
      res += i;
    }
    return res;
  }


}
