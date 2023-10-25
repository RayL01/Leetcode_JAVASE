import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Leetcode # 315
 * @Author: shadyyyyyl
 * @Date: 2023/09/04/18:28
 * @Description:
 */
public class countOfSmallerNumbersAfterSelf {


  @Test
  public void test(){
    List<Integer> x = countSmaller(new int[]{2, 0 , 1});
    x.forEach(System.out::println);
  }
  private int[] count;
  private int[] tmp;
  public List<Integer> countSmaller(int[] nums) {
    int n = nums.length;
    count = new int[n];
    tmp = new int[n];
    mergeSort(nums, 0, n - 1);
    return Arrays.stream(count).boxed().collect(Collectors.toList());
  }
  private void mergeSort(int[] nums, int lo, int hi){
    if(lo >= hi) return;
    int mid = (lo + hi) / 2;
    mergeSort(nums, lo, mid);
    mergeSort(nums, mid + 1, hi);
    merge(nums, lo, mid, hi);

  }
  private void merge(int[] nums, int lo, int mid, int hi){
    for(int i = lo; i <= hi; i++){
      tmp[i] = nums[i];
    }
    int i = lo;
    int j = mid + 1;
    int x = lo;
    while(x <= hi && i <= mid && j <= hi){
      if(tmp[i] <= tmp[j]){
        count[i] += (j - mid - 1);
        nums[x] = tmp[i];
        i++;
        x++;
      }else{
        nums[x] = tmp[j];
        x++;
        j++;
      }
    }
    while(j <= hi){
      nums[x] = tmp[j];
      j++;
      x++;
    }
    while(i <= mid){
      count[i] += (j - mid - 1);
      nums[x] = tmp[i];
      x++;
      i++;
    }
  }
}
