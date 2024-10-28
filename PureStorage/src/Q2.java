import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/11/08/12:59
 * @Description:
 */
public class Q2 {
  @Test
  public void test1(){
    List<List<Integer>> data = new ArrayList<>();
    List<Integer> list = Arrays.asList(2001, 1001, 3);
    List<Integer> list1 = Arrays.asList(2001, 1002, 2);
    List<Integer> list2 = Arrays.asList(2002, 1003, 1);
    List<Integer> list3 = Arrays.asList(2002, 1001, 2);
    List<Integer> list4 = Arrays.asList(2002, 1002, 3);
    List<Integer> list5 = Arrays.asList(2001, 1003, 1);
    data.add(list);
    data.add(list1);
    data.add(list2);
    data.add(list3);
    data.add(list4);
    data.add(list5);
    print_classification(data);

  }
  public void print_classification(List<List<Integer>> raw_data) {
    Map<Integer, Integer> scoreboard = new HashMap<>();

    for (List<Integer> entry : raw_data) {
      int racerId = entry.get(1);
      int position = entry.get(2);
      int points = getPoints(position);
      scoreboard.put(racerId, scoreboard.getOrDefault(racerId, 0) + points);
    }

    Optional<Map.Entry<Integer, Integer>> winner = scoreboard.entrySet()
            .stream()
            .min(Map.Entry.<Integer, Integer>comparingByValue().reversed()
                    .thenComparing(Map.Entry.comparingByKey()));

    if (winner.isPresent()) {

      System.out.println(winner.get().getKey() + " " + winner.get().getValue());
    }
  }
  private int getPoints(int position) {
    switch (position) {
      case 1: return 10;
      case 2: return 6;
      case 3: return 4;
      case 4: return 3;
      case 5: return 2;
      case 6: return 1;
      default: return 0;
    }
  }
}
