package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/13/23:34
 * @Description:
 * https://leetcode.com/problems/longest-palindromic-substring/submissions/
 */
public class LongestPalindrome {
  public String longestPalindrome(String s) {
    /*Time: O(n2)
    Space: O(n)   */
    // a a b a c d c a b
    //b c a a c b d g
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      String s1 = Find(s, i, i);
      String s2 = Find(s, i, i + 1);
      res = res.length() > s1.length() ? res : s1;
      res = res.length() > s2.length() ? res : s2;
    }
    return res;
  }
  public String Find(String s, int low, int high){
    while(low >= 0 && high <= s.length() - 1 && s.charAt(low) == s.charAt(high)){
      low--;
      high++;
    }
    return s.substring(low + 1, high);
  }
}
