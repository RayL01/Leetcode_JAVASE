package com.shady.Arrays.TwoPointers;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        //Initialize a pq in ascending order
        int res = -1;
        for (int i = 0; i < matrix.length; i++) {
            //There are 3 elements in the array. The first element in the array, row index, column index,  respectively.
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        while(!pq.isEmpty() && k > 0){
            int[] cur = pq.poll();
            if(k == 1){
                res = cur[0];
            }
            int row = cur[1];
            int column = cur[2];
            //Since we are pushing the next column to the pq
            if(column + 1 < matrix[row].length){
                pq.offer(new int[]{matrix[row][column + 1], row, column + 1});
            }
            k--;

        }
        return res;
    }
}
