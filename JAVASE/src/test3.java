import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/02/10:56
 * @Description:
 */
public class test3 {
  boolean inCircle(int x, int y, int xl, int yl, int R) {
    return (x - xl) * (x - xl) + (y - yl) * (y - yl) <= R * R;

  }

  int beaconSignal(int x1, int y1, int x2, int y2, int xl, int yl, int R) {
    int res = 0;
    HashMap map = new HashMap();
    for (int x = x1; x <= x2; x++) {
      if ((x - xl) * (x - xl) <= R * R) {
        double height = Math.sqrt(R * R - (x - xl) * (x - xl));
        int bottom = (int) Math.ceil(yl - height);
        int top = (int) Math.floor(yl + height);
        int upper = Math.min(top, y2);
        int lower = Math.max(bottom, y1);
        if (upper >= lower) {
          res += (upper - lower) + 1;
        }
      }
    }
    return res;
  }
}
