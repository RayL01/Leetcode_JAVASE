package com.shady.Arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/16/23:04
 * @Description: Reverse words in a  String
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Time: O(n) Space:O(n)
 */
public class ReverseWordsinaString {
  public String reverseWords(String s) {

    //First, we need to remove all the leading and trailing blank spaces in the given string
    String s1 = s.trim();
    //Using Collections.reverse
    List<String> list = Arrays.asList(s1.split("\\s+"));
    Collections.reverse(list);
    // blue is sky the
    //make it as a string
    return String.join(" ", list);

  }
}
