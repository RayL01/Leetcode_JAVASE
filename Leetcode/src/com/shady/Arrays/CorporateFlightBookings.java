package com.shady.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/11/16/22:04
 * @Description: Difference Array
 * https://leetcode.com/problems/corporate-flight-bookings/
 */
public class CorporateFlightBookings {
  class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
      int[] nums = new int[n];//all 0s
      RangeAddition.Difference difference = new RangeAddition.Difference(nums);
      for(int[] booking : bookings){
        difference.modify(booking[0] - 1, booking[1] - 1, booking[2]);
      }
      return difference.getResult();
    }
  }
}
