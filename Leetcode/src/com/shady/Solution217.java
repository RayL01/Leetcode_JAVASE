package com.shady;

import java.util.*;

//Given an integer array nums,
//        return true if any value appears at least twice in the array,
//        and return false if every element is distinct.
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        int size_l;
        int size_hash;
        Integer [] integer = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Collection list = Arrays.asList(integer);
        size_l = list.size();
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        size_hash = hashSet.size();
        size_hash = hashSet.size();//hashset will filter all duplicated elements
        if(size_hash != size_l){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,4};
        int num1[] = {1,1,4,5};
        Solution217 solution = new Solution217();
        ArrayList list;

        System.out.println(solution.containsDuplicate(num));
        System.out.println(solution.containsDuplicate(num1));

    }
}
