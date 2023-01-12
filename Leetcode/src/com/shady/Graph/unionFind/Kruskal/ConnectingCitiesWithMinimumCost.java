package com.shady.Graph.unionFind.Kruskal;

import com.shady.Graph.unionFind.UF;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/12/04:48
 * @Description: MST: 1.Tree structure 2. contains all nodes 3. minimal costs
 * Solved by union find and greedy algorithm
 * https://leetcode.com/problems/connecting-cities-with-minimum-cost/
 *
 * Time Complexity: Since all operations for union find is O(1), so the checking process takes O(E)
 * And the sort process takes O(ElogE), so the time complexity would be O(ElogE)
 * Space Complexity: It takes O(E) for all the nodes to store in the Parents[i] in UF.
 *
 */
public class ConnectingCitiesWithMinimumCost {
  public int minimumCost(int n, int[][] connections) {
    //First, we should sort all edges in the ascending order of weights

    //And since city number starts from 1, we have to add 1 to n
    UF uf = new UF(n + 1);
    int cost = 0;
    Arrays.sort(connections, (a, b) -> Integer.compare(a[2], b[2]));
    for (int[] connect: connections
         ) {
      int u = connect[0];
      int v = connect[1];
      int weight = connect[2];

      if(uf.connected(u, v)) continue;//go on to the next edge
      uf.union(u,v);
      cost += weight;
    }

    //Then, we should return the cost as the minimal cost, and we have to make sure that the tree is connected
    //But here, we can't return assuming that count() == 1. Because
    //We never use the point '0'
    return uf.count() == 2 ? cost : -1;
  }
}
