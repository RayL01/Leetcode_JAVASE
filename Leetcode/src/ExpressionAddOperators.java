import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/20/20:31
 * @Description:
 */
public class ExpressionAddOperators {
  @Test
  public void test(){
    List<String> res = addOperators("3456237490", 9191);
    System.out.println(res);
  }
  public String digits;
  public List<String> res;
  public List<String> addOperators(String num, int target) {
    this.digits = num;
    res = new ArrayList();
    
    backtrack((long)target, 0, 0, 0, 0, new StringBuilder());
    return res;

  }
  //10 + 2 * 4
  //10 + 2 - 3
  //10 + 02 * 3.   ❌ 10 + 0 + 2


  //backtrack(target, 0, 0, 0, new StringBuilder())
  private void backtrack(long target, int index, long curOperand, long prevOperand, long curValue, StringBuilder sb){

    //base case
    //1024
    //+ 10 + 2 * 4
    if(index == digits.length()){
      if(curValue == target && curOperand == 0){
        //current operand must be 0 to make sure that the "last curOperand is being added to the result"
        //for example : 10 + 27.    if we went with 'no op recursion' in the last recursion,
        //our current value would be 10    and if the target just happens to be 10 we will return 10,
        // but our input is 1027. our result doesn't match with the input


        //exclude the first character("+")
        res.add(sb.toString().substring(1));
      }
      return;
    }




    //retrieve the current digit
    int curDigit = Character.getNumericValue(digits.charAt(index));
    curOperand = curOperand * 10 + curDigit;

    //no-op recursion,  only if curOperand is not equal to 0
    if(curOperand > 0){
      backtrack(target, index + 1, curOperand, prevOperand, curValue, sb);
    }


    //'+'。  theres no restriction on +
    sb.append("+");
    sb.append(curOperand);
    backtrack(target, index + 1, 0, curOperand, curValue + curOperand, sb);
    //undo the changes in sb
    int lens = String.valueOf(curOperand).length();
    // 0 1 2
    //+ 1 0
    sb.delete(sb.length() - lens - 1, sb.length());



    if(!sb.isEmpty()){
      //'-' only if the current operand is not the first one
      sb.append("-");
      sb.append(curOperand);
      backtrack(target, index + 1, 0, curOperand, curValue - curOperand, sb);
      sb.delete(sb.length() - lens - 1, sb.length());

      //'*' only if the current operand is not the first one
      //10 + 2 * 4 * 8
      sb.append("*");
      sb.append(curOperand);
      backtrack(target, index + 1, 0, curOperand * prevOperand, (curValue - prevOperand) + (curOperand * prevOperand), sb);
      sb.delete(sb.length() - lens - 1, sb.length());
    }



  }
}
