package com.shady;

public class UniqueBinarySearchTrees {
  //Time: n2   Space: n2
  class Solution {
    int [][] memo;
    int numTrees(int n) {
      // 计算闭区间 [1, n] 组成的 BST 个数
      memo = new int[n + 1][n + 1];
      return count(1, n);

    }
    public int count(int lo,int hi){
      // 1, 2, 3, 4, 5, 6, 7, 8
      //if we want to build a BST, first we need to choose the root of the tree.
      //Once the root of the tree is determined, all the elements that on the left side of the element in the array is the left sub-tree, and same for the elements to the right.
      //And the number of the BST based on the chosen root can be calculated by the number of the BST in the left sub-tree times that in the right. And we can do it recursively in both left and right side.

      //First of all, we need to build the base case for the recursion.


      int sum = 0;
      if(lo > hi){
        return 1;
      }
      if(memo[lo][hi] != 0){
        return memo[lo][hi];
      }
      for (int i = lo; i <= hi; i++) {
          int left = count(lo, i - 1);
          int right = count(i + 1, hi );
          sum += (left * right);
      }
      memo[lo][hi] = sum;
      return sum;
    }
  }
}
