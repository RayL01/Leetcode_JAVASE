import java.util.ArrayList;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/24/21:02
 * @Description:
 */
public class starbucks2 {

  public static List<String> bitPattern(int[] numbers) {
    StringBuilder pattern1 = new StringBuilder();
    StringBuilder pattern2 = new StringBuilder();

    for (int idx = 0; idx < numbers.length; idx++) {
      // Check if number appears before
      boolean isPresentBefore = false;
      for (int j = 0; j < idx; j++) {
        if (numbers[idx] == numbers[j]) {
          isPresentBefore = true;
          break;
        }
      }

      if (isPresentBefore) {
        pattern1.append("1");
      } else {
        pattern1.append("0");
      }

      // Check if number appears again in the future
      boolean isPresentLater = false;
      for (int j = idx + 1; j < numbers.length; j++) {
        if (numbers[idx] == numbers[j]) {
          isPresentLater = true;
          break;
        }
      }

      if (isPresentLater) {
        pattern2.append("1");
      } else {
        pattern2.append("0");
      }
    }

    List<String> result = new ArrayList<>();
    result.add(pattern1.toString());
    result.add(pattern2.toString());

    return result;
  }

  public static void main(String[] args) {
    int[] testNumbers = {1, 2, 3, 2, 1, 4, 5, 5};
    List<String> patterns = bitPattern(testNumbers);
    for (String pattern : patterns) {
      System.out.println(pattern);
    }
  }

}
