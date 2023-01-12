package com.shady.Graph.unionFind;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/11/22:52
 * @Description:
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class NumberofConnectedComponentsinanUndirectedGraph {
  public int countComponents(int n, int[][] edges) {
    UF uf = new UF(n);
    for (int e[] : edges
         ) {
      uf.union(e[0],e[1]);
    }
    return uf.count();
  }

}
