package com.shady.Graph.unionFind.Kruskal;

import com.shady.Graph.unionFind.UF;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/12/05:19
 * @Description: Solved by Kruskal algorithm
 * https://leetcode.com/problems/min-cost-to-connect-all-points/
 * The cost of connecting two points [xi, yi] and [xj, yj]
 * is the manhattan distance between them: |xi - xj| + |yi - yj|,
 * where |val| denotes the absolute value of val.
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 */
public class MinCosttoConnectAllPoints {
  public int minCostConnectPoints(int[][] connections) {
    UF uf  = new UF(connections.length);
    List<int[]> distance = new ArrayList<>();
    //First, we should calculate the Manhattan distances between all the points
    for (int i = 0; i < connections.length; i++) {
      for (int j = i + 1; j < connections.length; j++) {
        int xi = connections[i][0];
        int yi = connections[i][1];

        int xj = connections[j][0];
        int yj = connections[j][1];

//        |xi - xj| + |yi - yj|
        int dist = Math.abs(xi - xj) + Math.abs(yi - yj);

        //Here, we take i, j as single points on the map
        distance.add(new int[]{i, j, dist});
      }
    }
    //Then, we should sort the list
    Collections.sort(distance, (a, b) -> Integer.compare(a[2], b[2]));

    //Then execute the Kruskal's algorithm
    int cost = 0;
    for (int[] dis: distance
         ) {
      if(uf.connected(dis[0],dis[1])){
        continue;
      }
      uf.union(dis[0],dis[1]);
      cost += dis[2];
    }
    //return uf.count() == 1 ? cost : -1;

    //Since edges between all the points are accessible, there's no need to determine the connectivity
    return cost;

  }
  @Test
  public void test(){
    System.out.println(minCostConnectPoints(new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}}));
  }
}
