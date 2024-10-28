import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/08/12:25
 * @Description:
 */
public class Q1 {

  /**
   * Q4 stack size
   * 3, 3, 4, 2, 5, 4
   *
   * 3 3
   *
   * 2 5
   *
   *
   * C
   *
   *
 *   Q3    B
   *   7 6 5 4 3 2 1 0
   *     f     g
   *   0 0 0 r f l a g   &
   *   0 0 0 0 1 1 1 1
   *   0 0 0 0 f l a g
   *
   *
   * Q5
   *
   *
   *
   */


  @Test
  public void test1(){
    find_doubles_in_list(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 8));
  }
  @Test
  public void test2(){
    find_doubles_in_list(List.of(7, 17, 11, 1, 23));
  }
  @Test
  public void test3(){
    find_doubles_in_list(List.of(1, 2, 1, 1, 2, 4));
  }

  public void find_doubles_in_list(List<Integer> values) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    List<Integer> result = new ArrayList<>();

    // Count the frequency of each number in the list
    for (int value : values) {
      frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
    }

    // Check for numbers whose double exists and the double has a frequency of 1
    for (int value : values) {
      if (frequencyMap.containsKey(value * 2) && frequencyMap.get(value * 2) == 1) {
        result.add(value);
      }
    }
    Collections.sort(result);
    // Print the result
    for (int num : result) {
      System.out.println(num);
    }

  }
}
