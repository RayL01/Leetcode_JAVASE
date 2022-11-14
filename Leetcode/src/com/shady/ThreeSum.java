package com.shady;

import org.junit.Test;

import java.util.*;

//15.
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.

public class ThreeSum {
    public static List<List<Integer>> ThreeSum(int[] nums){//3 numbers add up to 0
        Arrays.sort(nums);//First sort the given list
        List<List<Integer>> list = new ArrayList<>();
        //set up a loop and execute twoSum for each number in the iteration
        for (int i = 0; i < nums.length; i++) {
            int x = -nums[i];
            list = TwoSum2.twoSum2(nums, i + 1, x);
            for(List<Integer> integers : list ){
                integers.add(x);
            }
            //Since there may exist some duplicated values in the given array, we should skip those duplicates

            // 1 1 1 2 3 4 5 6
            while(i < nums.length && nums[i] == nums[++i]);
        }
        return list;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> hashset = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {//自己想的解法，时间复杂度为n^2,空间复杂度为n^2
            for (int head = 0,tail = nums.length - 1;head < tail ; ) {
                if(head == i){
                    head++;
                    continue;
                }
                if(tail == i){
                    tail--;
                    continue;
                }
                if(nums[head] + nums[tail] == -nums[i]){//找到对应
                    int num[] = new int[]{nums[i],nums[head],nums[tail]};
                    Arrays.sort(num);
                    Integer[] integers = Arrays.stream(num).boxed().toArray(Integer[]::new);
                    hashset.add(Arrays.asList(integers));
                    head++;
                    tail--;
                }else if(nums[head] + nums[tail] < -nums[i]){//比target小，head++
                    head++;
                }else{//nums[head] + nums[tail] > -nums[i]
                    tail--;
                }
                System.out.println("1111111");
            }
        }
        System.out.println();
        return new ArrayList<List<Integer>>(hashset);
    }
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }
    //solution 3 using hashset
    //Time Complexity: \mathcal{O}(n^2)O(n
    //2
    // ). twoSum is \mathcal{O}(n)O(n), and we call it nn times.
    //
    //Sorting the array takes \mathcal{O}(n\log{n})O(nlogn), so overall complexity is \mathcal{O}(n\log{n} + n^2)O(nlogn+n
    //2
    // ). This is asymptotically equivalent to \mathcal{O}(n^2)O(n
    //2
    // ).
    //
    //Space Complexity: \mathcal{O}(n)O(n) for the hashset.
    public List<List<Integer>> threeSum3(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        return res;
    }
    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])//重复数值需要跳过
                    ++j;
            }
            seen.add(nums[j]);//[-4,-1,-1,0,1,2，5]即使hashset里面没有-4 这个元素，-4
            //还是会被放到答案里面，是因为开始的时候-1被放进去，在最后到5的时候，contains(-1)为true，其实
            //跟two sum的hashset没有什么区别
        }
    }
    @Test public void test(){
        //nums = [-1,0,1,2,-1,-4]
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum1(nums));
    }
}
