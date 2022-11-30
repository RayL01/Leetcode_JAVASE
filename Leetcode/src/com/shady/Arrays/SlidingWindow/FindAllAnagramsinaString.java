package com.shady.Arrays.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/27/23:30
 * @Description: Using sliding window frame
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsinaString {

  /**
   * Input: s = "cbaebabacd", p = "abc"
   * Output: [0,6]
   * Explanation:
   * The substring with start index = 0 is "cba", which is an anagram of "abc".
   * The substring with start index = 6 is "bac", which is an anagram of "abc".
   * @param s
   * @param p
   * @return
   */
  public List<Integer> findAnagrams(String s, String p) {
    Map<Character,Integer> need = new HashMap<>();
    Map<Character, Integer> window = new HashMap<>();
    int left = 0, right = 0;
    int valid = 0;
    List<Integer> res = new ArrayList<>();
    for (Character character : p.toCharArray()){
      need.put(character, need.getOrDefault(character,0) + 1);
    }
    while(right < s.length()){
      char a = s.charAt(right);
      right++;

      //then we should update the window
      if (need.containsKey(a)){
        window.put(a, window.getOrDefault(a, 0) + 1);
        //After the update, if the number of a in the window is equal to the need, valid ++
        if(window.get(a).equals(need.get(a))){//valid ++
            valid++;
        }
      }

      //after that, we should determine whether we should shrink the window
      while((right - left) == p.length()){
        //determine whether elements in the current window meet the requirement for the answer
        if(valid == need.size()){
          res.add(left);
        }


        //move the left
        char c = s.charAt(left);
        left++;

        //update the window, if it is in the need, and the number is the same, valid--
        if(window.containsKey(c)){
          if(need.get(c).equals(window.get(c))){
            valid--;
          }
          //update the window
          window.put(c, window.get(c) - 1);
        }
      }
    }
    return res;
  }

}
