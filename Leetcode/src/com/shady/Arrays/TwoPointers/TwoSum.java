package com.shady.Arrays.TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int [] nums = new int[]{8,0,11,15,100,1};
        int [] num2 = sum.twoSum3(nums,9);
//        for (int i = 0; i < num2.length; i++) {
//            System.out.println(num2[i]);
//        }
        System.out.println(Arrays.toString(num2));
    }
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] >= target){
                continue;
            }
            for (int j = i + 1 ; j < nums.length; j++) {
                if(nums[j] >= target){
                    continue;
                }
                if((nums[i] + nums[j]) == target ){
                    return new int[]{i,j};
                }

            }
        }
        throw new RuntimeException("Input error!");
    }
    public int[] twoSum2(int nums[], int target){
        Map HashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            HashMap.put(nums[i], i);
        }
        for (int j = 0; j < nums.length; j++) {
            int x = target - nums[j];
            if(HashMap.containsKey(x)){
                return new int[]{j,(int)(HashMap.get(x))};
            }
        }

        return null;
    }
        public int[] twoSum3(int[] numbers, int target) {
            HashMap<Integer,Integer> indexMap = new HashMap<Integer,Integer>();
            for(int i = 0; i < numbers.length; i++){
                Integer requiredNum = (Integer)(target - numbers[i]);
                if(indexMap.containsKey(requiredNum)){
                    int toReturn[] = {indexMap.get(requiredNum), i};
                    return toReturn;
                }

                indexMap.put(numbers[i], i);
            }
            return null;
        }

}
