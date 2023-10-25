import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/22/14:20
 * @Description:
 */
public class test {
  boolean isValid(int[] ip) {
    for (int octet : ip) {
      if (octet < 0 || octet >= 256) {
        return false;
      }
    }
    return true;
  }

  int category(int[] ip) {
    if (!isValid(ip)) {
      return -1;
    }
    int first = ip[0];
    if (first < 128) {
      return 1;
    }
    if (first < 192) {
      return 2;
    }
    if (first < 224) {
      return 3;
    }
    if (first < 240) {
      return 4;
    }
    if (first < 256) {
      return 5;
    }
    return -1;
  }

  List<Integer> getRegions(List<String> ipAddresses) {
    List<int[]> parsedAddresses = new ArrayList<>();
    for (String addr : ipAddresses) {
      String[] parts = addr.split("\\.");
      int[] ipParts = new int[4];
      for (int i = 0; i < 4; i++) {
        ipParts[i] = Integer.parseInt(parts[i]);
      }
      parsedAddresses.add(ipParts);
    }
    List<Integer> result = new ArrayList<>();
    for (int[] ip : parsedAddresses) {
      result.add(category(ip));
    }
    return result;
  }
}
