package com.shady.Arrays.TwoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/13/21:39
 * @Description:
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {
  public void reverseString(char[] s) {
    int low = 0;
    int high = s.length - 1;
    /**
     * ["h","e","l","l","o"]
     * ["o","l","l","e","h"]
     *
     */
    while(low < high){
      char tmp = s[low];
      s[low] = s[high];
      s[high] = tmp;
      low++;
      high--;
    }
  }
}
