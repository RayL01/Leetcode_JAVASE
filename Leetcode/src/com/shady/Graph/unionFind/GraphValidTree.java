package com.shady.Graph.unionFind;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/12/04:07
 * @Description: Determine whether the graph is a tree(no cycles and connectivity#), solved by Union Find.
 * https://leetcode.com/problems/graph-valid-tree/
 */
public class GraphValidTree {
  public boolean validTree(int n, int[][] edges) {
    UF uf  = new UF(n);
    for (int e[]:edges
         ) {
      //Every time we when are adding a new edge, we should determine whether its ending points are already in the union.
      //If so, there should be a cycle, and we return false. Otherwise, we put them together into the union.
      if(uf.connected(e[0],e[1])){
        return false;
      }
      uf.union(e[0],e[1]);
    }


    //return true; We can't return true directly after the for loop, since
    //the graph may not be connected and hence can't be a tree

    //In this case, we should determine whether the current graph is connected
    //We can simply use the count() method to determine the connectivity
    return uf.count() == 1;
  }
  @Test
  public void test(){
    int[][] ints = new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}};
    boolean b = validTree(5, ints);
    System.out.println(b);
  }
}
