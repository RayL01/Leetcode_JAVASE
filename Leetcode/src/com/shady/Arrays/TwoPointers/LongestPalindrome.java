package com.shady.Arrays.TwoPointers;

import org.junit.Test;

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
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      String s1 = palindrome(s, i,i);
      String s2 = palindrome(s, i,i + 1);
      res = s1.length() > res.length() ? s1 : res;
      res = s2.length() > res.length() ? s2 : res;
    }
    return res;

  }
  private String palindrome(String s, int l, int r) {
    while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
      l--;
      r++;
    }
    return s.substring(l + 1,r);
  }
  @Test
  public void test(){
    String s = longestPalindrome("babad");
    System.out.println(s.substring(5,5));
  }

}
