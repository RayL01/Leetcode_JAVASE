package com.shady.java.sort;

public class InsertionSort {
    public static void main(String[] args) {
        int [] ints = {5,0,8,1,2,9};
        int [] int2 = {435,8,34,0,89,2,35,4,6,1};
        InsertionSort s = new InsertionSort();
        s.sort(int2);
        for (int i = 0; i < int2.length; i++) {
            System.out.println(int2[i]);
        }
    }
    public void sort(int a[]){
        for (int i = 0,tmp; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if(a[j] < a[j - 1]){
                    tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }else{
                    break;
                }
            }
        }
    }
}
