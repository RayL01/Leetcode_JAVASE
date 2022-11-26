package com.shady.Arrays.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/25/15:40
 * @Description: Sliding Window
 * //Time: O(N + M)
 * //Space : O(N + M)
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
  //Store the information for elements in the current window
  String minWindow(String s, String t){
    Map<Character, Integer> windowMap = new HashMap<>();

    //Store the info for elements wanted in the end
    Map<Character, Integer> targetMap = new HashMap<>();

    int left = 0, right = 0;//left and right pointer

    int start = 0, end = 0;//indexes for ending and starting substring
    int len = Integer.MAX_VALUE;

    int valid = 0;//We create a valid variable which represents the number of qualified elements in the window map

    //Init the targetMap
    for (Character character : t.toCharArray()) {
      targetMap.put(character, targetMap.getOrDefault(character, 0) + 1);
    }

    while(right < s.length()){
      //the character in the window
      char c = s.charAt(right);
      //expand the window
      right++;
      //update information for windowmap and targetmap
      if(targetMap.containsKey(c)){//put it into the windowHashmap
        windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        if(windowMap.get(c).equals(targetMap.get(c))){
          valid++;
        }
      }

      //Next, we should determine whether the current window is the same as the target
      //So the value for each key in the window map should be identical to that in target
      //so we create a valid variable which represents the number of qualified elements in the window map


      //next we need to determine whether the current window contains all the elements
      while(valid == targetMap.size()){
        //first we should update the indexes of substring for the result

        if((right - left) < len){//if current length < stored length, we update the start and end indexes.
          start = left;
          end = right;
          len = right - left;
        }

        //Then, we should shrink the size of the window, increasing left.

        char a = s.charAt(left);
        left++;

        //if a is in the target, decrease its corresponding value in window
        if(windowMap.containsKey(a)){

          //it is possible that the current number of a certain element in the window is larger than that in the target, so we should determine whether they are the same
          if(windowMap.get(a).equals( targetMap.get(a))){
            valid--;
          }
          windowMap.put(a, windowMap.get(a) - 1);

        }
      }

    }
    return s.substring(start, end + 1);
  }
}
