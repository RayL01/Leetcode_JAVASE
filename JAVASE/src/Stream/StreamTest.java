package Stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/15/01:13
 * @Description:
 */
public class StreamTest {
  @Test
  public void testStream(){
    int[] arr1 = new int[]{1, 2, 3};
    IntStream stream = Arrays.stream(arr1);
    List<Integer> res = new ArrayList<>();
    Stream<Integer> stream1 = Arrays.asList(1, 2, 3).stream();
    Stream<Integer> stream2 = Stream.of(1, 2, 3);
    List<Integer> arr2 = Arrays.asList(1, 2, 3, 4, 5);
    //convert List to an int array
    int[] convertArry = arr2.stream().mapToInt(Integer::intValue).toArray();
    List<Integer> collect = Arrays.stream(arr1)
            .boxed()
            .collect(Collectors.toList());



    int[][] twoDArray = new int[][]{
            {1, 2, 3},
            {2, 3, 4},
            {5,6,7}
    };

    Arrays.stream(twoDArray).map(ints ->
            Arrays.stream(ints).boxed().collect(Collectors.toList())
    ).collect(Collectors.toList());
    
    
    List<List<Integer>> nestedList = new ArrayList<>();
    int[][] ints = nestedList.stream().map(list ->
            list.stream().mapToInt(Integer::intValue)
                    .toArray()).toArray(int[][]::new);

  }
}
