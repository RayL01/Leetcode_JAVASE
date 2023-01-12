package com.shady.Graph.unionFind;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/11/23:51
 * @Description:
 * https://leetcode.com/problems/satisfiability-of-equality-equations/
 * Input: equations = ["a==b","b!=a"]
 * Output: false
 * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.
 * There is no way to assign the variables to satisfy both equations.
 */
public class SatisfiabilityofEqualityEquations {
  public boolean equationsPossible(String[] equations) {
      //In this particular case, let's assume that a and b can be put together into a union if a == b
      //And we union all cases
      //After that, if any pair exists
    //Since there are 26 letters, so the count would be 26
    UF uf = new UF(26);
    for (String s:equations //Select all the '==' pair and put them together into the union
         ) {
      if(s.contains("==")){//"a==b"
        char a = s.charAt(0);
        char b = s.charAt(3);
        uf.union(a - 'a', b - 'a');
      }
    }

    //After the for loop, we should check if any of the pairs of "!=" already exists in the union
    for (String s: equations
         ) {
      if(s.contains("!=")){
        char a = s.charAt(0);
        char b = s.charAt(3);
        if(uf.connected(a - 'a', b - 'a')) return false;
      }
    }
    return true;
  }
  @Test
  public void test(){
    boolean b = equationsPossible(new String[]{"a==b", "b!=a"});
    System.out.println(b);
  }
}
