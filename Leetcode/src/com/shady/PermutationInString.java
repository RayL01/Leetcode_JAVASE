package com.shady;

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
  class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int letterMap1[] = new int[26];//store the frequency of 26 letters in the sub string s1

      //initialize the frequency array for string s1
      for (int i = 0; i < s1.length(); i++) {
        letterMap1[s1.charAt(i) - 'a']++;// increase the number of occurrence of the letters in the substring s1.
      }

      for (int i = 0; i < s2.length() - s1.length() + 1; i++) {
        int letterMap2[] = new int[26];
        for (int j = 0; j < s1.length(); j++) {
          letterMap2[s2.charAt(i + j) - 'a']++;
        }
        if (compareFrequency(letterMap1, letterMap2)) {
          return true;
        }
      }

      return false;
    }

    /**
     * Write another method to compare if the frequency of the sliding window is the same as the s1;
     */
    public boolean compareFrequency(int[] arr1, int[] arr2){
      for (int i = 0; i < 26; i++) {
        if(arr1[i] != arr2[i]){
          return false;
        }
      }
      return true;
    }
  }
}
