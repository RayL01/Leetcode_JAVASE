package com.shady;
//128.
//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//        You must write an algorithm that runs in O(n) time.
//
//
//
//        Example 1:
//
//        Input: nums = [100,4,200,1,3,2]
//        Output: 4
//        Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//        Example 2:
//
//        Input: nums = [0,3,7,2,5,8,4,6,0,1]
//        Output: 9

import java.util.HashSet;
import java.util.Set;
//Time complexity : O(n)O(n).
//
//Although the time complexity appears to be quadratic due to the while loop nested within the for loop, closer inspection reveals it to be linear.
// Because the while loop is reached only when currentNum marks the beginning of a sequence (i.e. currentNum-1 is not present in nums),
// the while loop can only run for nn iterations throughout the entire runtime of the algorithm. This means that despite looking like O(n \cdot n)O(n⋅n) complexity,
// the nested loops actually run in O(n + n) = O(n)O(n+n)=O(n) time. All other computations occur in constant time, so the overall runtime is linear.
//
//Space complexity : O(n)O(n).
//
//In order to set up O(1)O(1) containment lookups, we allocate linear space for a hash table to store the O(n)O(n) numbers in nums. Other than that, the space complexity is identical to that of the brute force solution.
public class LongestConsecutive {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for(int n : nums){
                set.add(n);//将元素放入hashset
            }
            int longestLength = 1;
            for(int i : set){
                //首先，为了防止重复计算，需要判断当前数字前面是否在数组中是否存在，
                // 若存在，说明该序列已经计算过了。
                //若不存在，则进入循环计算长度。
                int currentLength = 1;
                if(set.contains(i - 1)){
                    continue;//若存在，说明该序列已经计算过，直接跳到下一个数字
                }
                while(set.contains(i + 1)){
                    currentLength ++;
                    i++;
                }
                longestLength = Math.max(longestLength, currentLength);
                //出循环后，将longestLength 换为currentLength的值
            }
            return longestLength;
        }
    }
}
