package com.shady;
//125. Valid Palindrome
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
public class ValidPalindrome {

    class Solution {//Solution 1 Time complexity: O(n)
        //Space complexity: O(n).
        //This solution uses the brute force to solve the problem.
        public boolean isPalindrome(String s) {//this solution
            StringBuilder builder = new StringBuilder();
            for(char a : s.toCharArray()){
                if(Character.isLetterOrDigit(a)){
                    builder.append(Character.toLowerCase(a));
                }
            }
            String s1 = builder.toString();
            String s2 = builder.reverse().toString();
            if(s1.equals(s2)){
                return true;
            }
            return false;

        }
    }
}
