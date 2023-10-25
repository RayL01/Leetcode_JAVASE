import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/19/01:00
 * @Description:
 */
public class Median {
  @Test
  public void test(){
    double result = findMedianSortedArrays(new int[]{1,3}, new int[]{2});
    System.out.println(result);
    String s = "123";
    Character c =  '5';
    System.out.println(Integer.valueOf(123));
    StringBuilder sb = new StringBuilder();

  }
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int[] A = nums1;
    int[] B = nums2;
    int total = A.length + B.length;
    int half = total / 2;

    if (B.length < A.length) {
      int[] temp = A;
      A = B;
      B = temp;
    }

    int l = 0, r = A.length - 1;

    while (true) {

      int i = Math.floorDiv(l + r, 2);
      int j = half - i - 2;

      int Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
      int Aright = ((i + 1) < A.length) ? A[i + 1] : Integer.MAX_VALUE;
      int Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
      int Bright = ((j + 1) < B.length) ? B[j + 1] : Integer.MAX_VALUE;

      if (Aleft <= Bright && Bleft <= Aright) {
        if (total % 2 == 1) {
          return Math.min(Aright, Bright);
        }
        return (double) (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2;
      } else if (Aleft > Bright) {
        r = i - 1;
      } else {
        l = i + 1;
      }
    }
  }
}
