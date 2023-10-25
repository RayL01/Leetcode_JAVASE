import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/08/26/22:48
 * @Description:
 */
public class countInversion {
  @Test
          public void test(){
    int res = count(new int[]{
            7,8,5,2,5
    });

    System.out.println(res);
    int[] ints = new int[1];
    Arrays.sort(ints);
    List<Integer> list = new ArrayList<>();
    Collections.sort(list);


    int[] r = new int[]{1, 2, 3};
  }


  /**
   * count the number of inversions required to sort the list
   * @param arr
   * @return
   */
  int res = 0;
  public int count(int[] arr){
    /**
     * 0 1 2 3 4 5 6 7
     * 4 5 5 6|1 4 3 9
     * 4 5 5|6 1
     *
     */
    //We utilize merge sort to determine the number of inversions happened in the process of sorting the array
    mergeSort(arr, 0, arr.length -1);
    return res;

  }
  private void mergeSort(int[] arr, int low, int high){
    //base case
    if (low >= high){
      return;
    }
    int mid = (low + high) / 2;


    /**
     * 1 2
     */
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);

  }

  private void merge(int[] arr, int low, int mid, int high){
    /**
     *  1     2
     */

    /** i               j
     *  27 28        3 43
     *   i              j
     *  1 27 28        3 43
     *    index
     *  3 28         3 43
     *  3 27 28 43，   9 10 82
     *
     *  3 9 27 28 43 10 82
     *
     *
     *
     */
    int lenLeft = mid - low + 1;
    int lenRight = high - mid;
    int[] arrLeft = new int[lenLeft];
    int[] arrRight = new int[lenRight];
    int left = 0;
    int right = 0;
    int index = low;
    //arrLeft : low mid       arrRight: mid + 1   high
    //copy data from arr to arrLeft
    for (int i = 0; i < lenLeft; i++) {
      arrLeft[i] = arr[low + i];
    }

    //copy data from array to arrRight
    for (int i = 0; i < lenRight; i++) {
      arrRight[i] = arr[mid + 1 + i];
    }


    while(left < lenLeft && right < lenRight){
      if(arrLeft[left] <= arrRight[right]){
        arr[index] = arrLeft[left];
        left++;
      }else{
        arr[index] = arrRight[right];
        right++;
      }
      index++;
    }
    //It's possible that when one array is finished, the other array is not, so we should fill the array with the rest of the array left
    while(left != lenLeft){
      arr[index] = arrLeft[left];
      index++;
      left++;
    }
    while(right != lenRight){
      arr[index] = arrRight[right];
      index++;
      right++;
    }

   //Lastly, we should calculate/** i               j
    //     *  27 28        3 43
    //     *   i              j
    //        l     mid     m+1  h
    //     *  1 27 28        3 43
    //     *    index
    //     *  3 28         3 43
    //     *  3 27 28 43，   9 10 82
    //     *
    //     *  3 9 27 28 43 10 82
    //     *




    //     *
    //     */
    // 2        4
    // 1    2    4   arr
    // 2 4          1
    // left        right
    for (int i = 0; i < lenRight; i++) {
      for (int j = 0; j < lenLeft; j++) {
        if(arrRight[i] < arrLeft[j]){
          res += (lenLeft - j);
          break;
        }
      }
    }
  }
}
