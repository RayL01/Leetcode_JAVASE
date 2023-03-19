package com.shady.Arrays.TwoPointers;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/14/00:50
 * @Description:https://leetcode.com/problems/is-subsequence/description/
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 */
public class IsSubsequence {
  public boolean isSubsequence(String s, String t) {
    //Use two pointers
    int j = 0;
    for (int i = 0; i < t.length() && j < s.length(); i++) {
      if(s.charAt(j) == t.charAt(i)) j++;
    }
    if(j == s.length()) return true;
    return false;
  }
}
