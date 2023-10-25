import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/10/18/20:26
 * @Description:
 */
public class visa {
  public static int[] processMemoryOps(String[][] ops, int total) {
    // Create an array to represent the memory slots.
    // If a slot is occupied, it will have a value of 1, otherwise 0.
    int[] memSlots = new int[total];
    int[] result = new int[ops.length];

    // Iterate over each operation.
    for (int o = 0; o < ops.length; o++) {
      String[] op = ops[o];
      String action = op[0];
      int start = Integer.parseInt(op[1]);
      int num = Integer.parseInt(op[2]);

      // Handling the 'store' action.
      if (action.equals("store")) {
        int idx = start;
        int initialPass = 1;

        // Find the starting index where the memory slots are free.
        while ((idx < total || (idx - total < start && initialPass == 2)) && memSlots[idx % total] == 1) {
          idx++;
          if (idx == total) {
            idx = 0;
            initialPass = 2;  // Indicates we have looped around once.
          }
        }

        int count = 0;
        int startIdx = idx;

        // Check if we have sufficient contiguous free slots from the starting index.
        while ((idx < total || (idx - total < start && count < num)) && count < num) {
          if (memSlots[idx % total] == 0) {
            count++;
          }
          idx++;
        }

        // If we found sufficient free slots, occupy them.
        if (count == num) {
          for (int i = 0; i < num; i++) {
            memSlots[(startIdx + i) % total] = 1;
          }
          result[o] = startIdx;

        } else {
          result[o] = -1;  // Indicate failure to allocate memory.
        }

        // Handling the 'free' action.
      } else {
        // Free up the specified number of slots.
        for (int i = 0; i < num; i++) {
          memSlots[(start + i) % total] = 0;
        }
        result[o] = num; // Indicate the number of slots freed up.
      }
    }
    return result;
  }

}
