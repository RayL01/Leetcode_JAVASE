package com.shady.Arrays.TwoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/17/01:33
 * @Description:
 */
public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1;
    int cur = nums1.length - 1;
    while(i >= 0 && j >= 0){
      if(nums1[i] < nums2[j]){
        nums1[cur] = nums2[j];
        j--;
      }else{
        nums1[cur] = nums1[i];
        i--;
      }
      cur--;
    }

    while(j >= 0){
      nums1[cur] = nums2[j];
      cur--;
      j--;
    }

  }
}
