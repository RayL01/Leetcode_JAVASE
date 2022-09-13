package com.shady;

import java.util.Arrays;
//anagram
//无改动

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        char [] a = s.toCharArray();
        char [] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if(Arrays.compare(a,b) == 0){
            return true;
        }else{
            return false;
        }




    }

    public static void main(String[] args) {
        String a1 = "anagram";
        String a2=  "ramgaan";
        Solution242 solution242 = new Solution242();
        System.out.println(solution242.isAnagram(a1,a2));
    }
}
