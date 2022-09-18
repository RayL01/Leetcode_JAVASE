package com.shady;

public class ProductofArrayExceptSelf {
    class Solution1{ //Time : O(n)    Space : O (n)    Solution 1
        public int[] productExceptSelf(int[] nums) {
            int l = nums.length;
            int[] left = new int[l];
            int[] right = new int[l];
            int [] ans = new int[l];

            left[0] = 1;
            for (int i = 1; i < l; i++) {
                left[i] = left[i - 1] * nums[i - 1];
            }

            right[l - 1] = 1;
            for (int j = l - 2; j >= 0  ; j--) {
                right[j] = right[j + 1] * nums[j + 1];
            }
            for (int i = 0; i < l; i++) {
                ans[i] = left[i] * right[i];
            }



            return ans;
        }
    }
    class Solution2 { //Time : O(n)    Space : O (1)    Solution 2
        public int[] productExceptSelf(int[] nums) {
            int l = nums.length;
            int[] left = new int[l];//即是左数组，又是最后返回的答案数组


            left[0] = 1;
            for (int i = 1; i < l; i++) {
                left[i] = left[i - 1] * nums[i - 1];
            }

            int right = 1;
            for (int j = l - 1; j >= 0 ; j--) {
                int n = right;
                right *= nums[j];
                left[j] *= n;
            }
            return left;
        }
    }
}
