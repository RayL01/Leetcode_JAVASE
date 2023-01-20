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
  public class Solution extends Relation {
    public int findCelebrity(int n) {
      if(n == 1) return 0; //exception, return false
      //Use a linkedlist as a container
      LinkedList<Integer> q = new LinkedList<>();
      for (int i = 0; i < n; i++) {
        q.add(i);
      }

      //Then each time we pull two elements out of the container and exclude one from the candidate queue.
      while(q.size() > 1){
        int cand = q.pollFirst();
        int nobody = q.pollFirst();

        //Then we should determine whether the current candidate is a potential celebrity, if so add it to queue.
        //Otherwise nobody is likely to be a celebrity
        if(knows(nobody, cand) && !knows(cand, nobody)){
          q.add(cand);
        }eles{
          q.add(nobody);
        }
      }
      //After the loop, there's only one element in the queue, but we still need to make sure that this one is who we are looking for
      int cand = q.pollFirst();
      int i;
      for ( i = 0; i < n; i++) {
        if(cand == i)continue;
        if(knows(i,cand) && !knows(cand,i)){
          continue;
        }else{
          break;
        }

      }
      if(i ==n ) {
        return cand;
      }
      return -1;
    }
  }
}
