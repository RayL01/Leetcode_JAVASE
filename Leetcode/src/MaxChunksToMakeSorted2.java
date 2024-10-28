import org.junit.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/12/02/16:59
 * @Description:
 */
public class MaxChunksToMakeSorted2 {
  @Test public void test(){
    int x = maxChunksToSorted(new int[]{2, 1, 3, 4, 4});

  }
  public int maxChunksToSorted(int[] arr) {
    //to solve this problem, we have to make sure that the current max element in the current chunk is smaller than the min element to the right of the current number
    //in order to do that, we gotta construct a min x[] where x[i] refers to the min value from index i to the end of the current array
    int minArr[] = new int[arr.length];
    int min = Integer.MAX_VALUE;
    Arrays.fill(minArr, Integer.MAX_VALUE);
    for(int i = arr.length - 1; i >= 0; i--){
      if(arr[i] < min){
        min = arr[i];

      }
      minArr[i] = min;

    }

    int curMax = 0;//the current max element in the current chunk
    int numOfChunk = 0;
    for(int i = 0; i < arr.length; i++){
      if(i + 1 < arr.length){
        curMax = Math.max(curMax, arr[i]);
        if(curMax <= minArr[i + 1]){
          numOfChunk++;
          curMax = 0;
        }
      }else{
        //the current element is the last digit in the array
        numOfChunk++;
      }
    }
    return numOfChunk;


  }

}
