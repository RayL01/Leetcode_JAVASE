package com.shady;
//11. container with most water
//Time complexity: O(n)O(n). Single pass.
//
//Space complexity: O(1)O(1). Constant space is used.
public class ContainerWithMostWater {
    public int maxArea(int[] height) {//将two pointers加在数组的头和末尾
       int Max = 0;
       int head = 0;
       int tail = height.length - 1;
       while(head < tail){
           int width = tail - head;
           if(height[head] <= height[tail]){
               head++;
               Max = Math.max(Max, width * head);
           }else{
               tail--;
               Max = Math.max(Max, width * tail);
           }
       }
       return Max;
    }
}
