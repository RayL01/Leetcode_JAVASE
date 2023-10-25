import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/18/22:11
 * @Description:
 */
public class reversePair {
  @Test
  public void test(){
    int[] test = new int[]{6,2};
    int[] expected = new int[]{2,6};
    reverse(test);
    Assert.assertArrayEquals(expected, test);

  }
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
}
