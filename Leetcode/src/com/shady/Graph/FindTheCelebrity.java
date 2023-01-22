package com.shady.Graph;

import java.util.LinkedList;
import java.util.WeakHashMap;

import javax.management.relation.Relation;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/19/20:30
 * @Description: Celebrity definition: everyone knows him, but he doesn't know anyone
 * https://leetcode.com/problems/find-the-celebrity/
 */
public class FindTheCelebrity {
//  public class Solution extends Relation {
//    public int findCelebrity(int n) {
//      if(n == 1) return 0; //exception, return false
//
//      int cand = 0;
//      for (int nobody = 1; nobody < n; nobody++) {
//        //If the current candidate is not the celebrity, we switch the cand to current nobody and move on
//        if(knows(cand, nobody) || !knows(nobody, cand)){
//          cand = nobody;
//        }
//        //No need for else, since if current cand is a potential candidate, we can keep going and see if other nobody matches with the condition.
//      }
//      //After the loop, there's only one element in the queue, but we still need to make sure that this one is who we are looking for
//
//      int i;
//      for ( i = 0; i < n; i++) {
//        if(cand == i)continue;
//        if(knows(i,cand) && !knows(cand,i)){
//          continue;
//        }else{
//          break;
//        }
//
//      }
//      if(i ==n ) {
//        return cand;
//      }
//      return -1;
//    }
//  }
}
