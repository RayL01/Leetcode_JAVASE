package com.shady;
//Given an integer array nums and an integer k,
// return the k most frequent elements.
// You may return the answer in any order.

import java.util.*;

/*Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]*/
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer I = nums[i];
            if(map.containsKey(I)){
                int s = map.get(I);
                map.put(I,++s);
            }else{//新建一个
                Integer integer = 1;
                map.put(I, integer);
            }
        }
        System.out.println(map);
        int[] list= new int[nums.length];
        //遍历map将数据放入数组
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer I = iterator.next();
            list[map.get(I)] = I;

        }
        System.out.println("****");
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        System.out.println("*******");
        //最后从数组尾部开始遍历
        int [] result = new int[k];
        int current = 0;
        for (int i = list.length - 1; i > 0; i--) {
            if(list[i] != 0) {
                if (--k == 0) {
                    result[current] = list[i];
                    return result;
                }else{
                    result[current++] = list[i];
                }
            }
        }
            return null;
    }


        /**
         * Time Complexity: O(nlog(k))
         * Space Complexity: O(n)
         */
        /*Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]*/
        /*
        map : 1-3
              2-2
              3-1
         */
        //leetcode solution 1
        public int[] topKFrequent1(int[] nums, int k) {
            int[] arr = new int[k];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);//
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (a, b) ->
                            a.getValue() - b.getValue()
            );
            for (Map.Entry<Integer, Integer> it : map.entrySet()) {
                pq.add(it);
                if (pq.size() > k) pq.poll();
            }
            int i = k;
            while (!pq.isEmpty()) {
                arr[--i] = pq.poll().getKey();
            }
            return arr;
        }

    public static void main(String[] args) {
        TopKFrequent topKFrequent =  new TopKFrequent();
        int nums [] = new int[]{1,1,1,2,2,3};
        int nums1 [];
        nums1 = topKFrequent.topKFrequent(nums, 2);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

}
