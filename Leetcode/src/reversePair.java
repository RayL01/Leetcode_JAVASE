import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/18/22:11
 * @Description:
 */
public class reversePair {
  
  public void reverse(int[] arr){
    int firstIndex;
    int secondIndex;
    for (int i = 0; i < arr.length; i = i + 2) {
      firstIndex = i;
      secondIndex = i + 1;
      if(secondIndex >= arr.length || firstIndex >= arr.length)  break;
      int tmp = arr[firstIndex];
      arr[firstIndex] = arr[secondIndex];
      arr[secondIndex] = tmp;

    }
    
  }
  public static void main(String[] args) {
    Map<Integer,Integer> map = new HashMap<>();
    //iterate through the map
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      System.out.println("Key = " + entry.getKey() +
          ", Value = " + entry.getValue());

    }
    String s = " ";
    s += "ab";
    System.out.println(s);
  }
}
