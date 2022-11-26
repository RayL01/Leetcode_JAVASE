package com.shady.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 *
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */

public class PermutationInString {
  /**
   * Time complexity:O(l1 + 26*(l2-l1))
   * Space complexity: O(1)
   */

  boolean checkInclusion(String t, String s){
    Map<Character, Integer> window = new HashMap<>();
    Map<Character, Integer> need = new HashMap<>();
    int left = 0, right = 0;//left and right pointer
    int valid = 0;
    for (Character character : t.toCharArray()) {
      need.put(character, need.getOrDefault(character, 0) + 1);
    }

    while(right < s.length()){
      char c = s.charAt(right);
      right++;
      if(need.containsKey(c)){//put it into the windowHashmap
        window.put(c, window.getOrDefault(c, 0) + 1);
        if(window.get(c).equals(need.get(c)))
          valid++;
      }
      while((right - left) >= t.length()){
        if(valid == need.size())//if current length < stored length, we update the start and end indexes.
          return true;
        char d = s.charAt(left);
        left++;
        if(need.containsKey(d)){
          if(window.get(d).equals(need.get(d)))
            valid--;
          window.put(d, window.get(d) - 1);
        }
      }
    }
    return false;
  }

}
