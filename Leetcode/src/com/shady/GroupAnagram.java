package com.shady;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Solution 49
/*Input: strs = ["eat","tea","tan","ate","nat","bat"]
        Output: [["bat"],["nat","tan"],["ate","eat","tea"]]*/
//Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.


public class GroupAnagram {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String,List<String>> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] alf = new char[26]; //存放字母个数,用char数组存放是因为能够呗转换成String，便于存储
                for(char c : strs[i].toCharArray()){
                    alf[(c - 'a')]++;//存放每个单词中各个字母的个数

                }
                String s = String.valueOf(alf);
                //接下来则是要判断map中是否存在存放的字母个数的这个key，如果存在，则将对应的strs[i]存放到map的<List<String>>中去
                //若不存在，则是map.put
                if(map.containsKey(s)){
                    map.get(s).add(strs[i]);
                }else{
                    List<String> list= new ArrayList<>();
                    list.add(strs[i]);
                    map.put(s,list);
                }

            }
            List finalList = new ArrayList<>();
            finalList.addAll(map.values());
            return finalList;


//            return new ArrayList<>(map.values());

        }


    }




}