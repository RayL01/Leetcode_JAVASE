package com.shady;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingNumbers {
  /**
   * Time complexity : O(2n) = O(n)O(2n)=O(n). In the worst case each character will be visited twice by ii and jj.
   *
   * Space complexity : O(min(m, n))O(min(m,n)). Same as the previous approach. We need O(k)O(k) space for the sliding window, where kk is the size of the Set. The size of the Set is upper bounded by the size of the string nn and the size of the charset/alphabet mm.
   */

  class Solution{
    public int lengthOfLongestSubstring(String s) {
      Map<Character, Integer> chars = new HashMap<>();
      int left = 0, right = 0;
      int res = 0;
      while (right < s.length()){
        char a = s.charAt(right);
        chars.put(a, chars.getOrDefault(a, 0) + 1);
        while(chars.get(a) > 1){
          char b = s.charAt(left);
          chars.put(b, chars.get(b) - 1);
          left++;
        }
        res = Math.max(res, right - left + 1);
        right++;

      }


      return res;
    }
  }

  /**
   * Optimized version, store the index of the previous duplicate so that left can jump to the index + 1
   * Space: O(m)
   */
  class Solution1{
    public int lengthOfLongestSubstring(String s) {
      Integer[] chars = new Integer[128]; // store the index of the letter

      int left = 0, right = 0;
      int res = 0;
      while (right < s.length()){
        char a = s.charAt(right);
        //chars.put(a, chars.getOrDefault(a, 0) + 1);
        Integer index = chars[a]; //get the index of the letter;
        if(index != null && index >= left)//the letter is already inside the sliding window
        {//> case: abbab    >= case : abcabcbb
          left = index + 1;
        }
        chars[a] = right;
        res = Math.max(res, right - left + 1);
        right++;

      }


      return res;
    }
  }
}
