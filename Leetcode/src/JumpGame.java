import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2024/10/25/20:16
 * @Description:
 */
public class JumpGame {
  public int jump(int[] nums) {
    int n = nums.length;
    int end = 0, farthest = 0;
    int jumps = 0;
    for (int i = 0; i < n - 1; i++) {
      farthest = Math.max(nums[i] + i, farthest);
      if (end == i) {
        jumps++;
        end = farthest;
      }
    }
    return jumps;
  }
  @Test
  public void test(){
    int res = jump(new int[]{3});
    System.out.println(res);
  }
}
