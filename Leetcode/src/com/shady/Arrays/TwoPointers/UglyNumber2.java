package com.shady.Arrays.TwoPointers;

import org.junit.Test;

import java.util.PriorityQueue;

public class UglyNumber2 {
    public int nthUglyNumber(int n) {
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int product2= 1;
        int product3 = 1;
        int product5 = 1;

        int[] ugly = new int[n];
        for (int i = 0; i < n ; i++) {
            int min = Math.min(Math.min(product2, product3), product5);
            // 1
            if(min == product2){
                ugly[i] = product2;
                product2 = ugly[p2] * 2;
                p2++;
            }
            if(min == product3){
                ugly[i] = product3;
                product3 = ugly[p3] * 3; //
                p3++;
            }
            if(min == product5){
                ugly[i] = product5;
                product5 = ugly[p5] * 5;
                p5++;
            }
        }
        return ugly[n - 1];
        //1, 2, 3, 4, 5, 6, 8, 9, 10, 12,
    }
    @Test
    public void test(){
        int n = nthUglyNumber(11);
        //1 1*2 3

        //2
        //3
        //5

    }
}
