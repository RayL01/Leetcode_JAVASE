package com.shady.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/29/22:47
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @Description: Using sliding window
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingNumber {
  public int lengthOfLongestSubstring(String s){
    Map<Character, Integer> window = new HashMap<>();
    int left = 0;
    int right = 0;
    int res = 0;
    while(right < s.length()){
      char a = s.charAt(right);
      right++;
      window.put(a, window.getOrDefault(a, 0) + 1);
      while(window.get(a) != 1)//shrink the current window
      {
        char c = s.charAt(left);
        left++;
        window.put(c, window.get(c) - 1);
      }
      //if no repeating characters, update the result.
      res = Math.max(res, right - left);
    }
    return res;
  }

}
