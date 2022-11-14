package com.shady;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//167. Two Sum II - Input Array Is Sorted
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
//
//Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
//
//The tests are generated such that there is exactly one solution. You may not use the same element twice.
//
//Your solution must use only constant extra space.
//
//
//
//Example 1:
//
//Input: numbers = [2,7,11,15], target = 9
//Output: [1,2]
//Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
//Example 2:
//
//Input: numbers = [2,3,4], target = 6
//Output: [1,3]
//Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
//Complexity Analysis
//
//Time complexity: O(n)O(n). The input array is traversed at most once. Thus the time complexity is O(n)O(n).
//
//Space complexity: O(1)O(1). We only use additional space to store two indices and the sum, so the space complexity is O(1)O(1).
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        for(int i = 0, j = numbers.length - 1; i < j; ) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{++i, ++j};//如果等于的话，直接返回i和j
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {//num[i]+num[j] < target
                i++;
            }
        }
        return null;
    }
    public static List<List<Integer>> twoSum2(int[] numbers, int index, int target){//final version: you have to return all the non-duplicated tuples in the array
        Arrays.sort(numbers);
        int low = index;
        int high = numbers.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                list.add(new ArrayList<>(Arrays.asList(numbers[low], numbers[high])));
                //next, we should skip duplicated values in the given array, and we should do it from both ends
                // given val = 6
                // 1 1 1  2 3 4  5 5 5 5
                //
                while(low < high && numbers[low] == numbers[++low]);
                while (low < high && numbers[low] == numbers[--high]);


            }else if(sum > target){
                while(low < high && numbers[high] == numbers[--high]);
            }else{
                while(low < high && numbers[low] == numbers[++low]);
            }
        }
        return list;


    }
}
