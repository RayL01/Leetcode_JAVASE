import java.util.Arrays;
import java.util.HashSet;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/09/14/20:46
 * @Description:
 */
public class findSegmentsOfHouses {

    public static void main(String[] args) {
      int[] houses = {1,2,3,6,7,9};
      int[] queries = {6,3,7,2,9,1};
      int[] result = countHouseSegments(houses, queries);

      for (int i : result) {
        System.out.print(i + " ");
      }
    }

    public static int[] countHouseSegments(int[] houses, int[] queries) {
      // Sort the houses array for easier manipulation
      Arrays.sort(houses);

      // Initialize variables
      int segments = 1;  // Initially, all houses form one segment
      int[] results = new int[queries.length];

      // Create a HashSet for quick look-up
      HashSet<Integer> houseSet = new HashSet<>();
      for (int house : houses) {
        houseSet.add(house);
      }

      // Count the initial number of segments
      for (int i = 1; i < houses.length; i++) {
        if (houses[i] != houses[i - 1] + 1) {
          segments++;
        }
      }

      for (int i = 0; i < queries.length; i++) {
        int query = queries[i];

        // Check if the house had a neighbor on the left or right before removal
        boolean hasLeft = houseSet.contains(query - 1);
        boolean hasRight = houseSet.contains(query + 1);

        // Update the number of segments based on the neighbors
        if (hasLeft && hasRight) {
          segments++;
        }
        if(!hasLeft && !hasRight){
          segments--;
        }

        // Remove the queried house
        houseSet.remove(query);

        results[i] = segments;
      }

      return results;
    }



}
