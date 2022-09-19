package com.shady;

import org.junit.Test;

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
        public boolean isPalindrome1(String s) {//Solution 2. Using two pointers at each end of the string.
            int length = s.length();
            for(int i = 0, j = length - 1; i < j; ){
                if(!Character.isLetterOrDigit(s.charAt(i))){
                    i++;
                    continue;//跳到下一个i，j的位置不变
                }
                if(!Character.isLetterOrDigit(s.charAt(j))){
                    j--;
                    continue;
                }
                if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                    return false;
                }
                i++;
                j--;
            }
            return true;

        }
    @Test
    public  void test(){
            String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome1(s));
    }
}
