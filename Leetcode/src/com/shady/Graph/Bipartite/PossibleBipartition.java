package com.shady.Graph.Bipartite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/01/08/22:47
 * @Description:
 * https://leetcode.com/problems/possible-bipartition/
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: The first group has [1,4], and the second group has [2,3].
 */
public class PossibleBipartition {
  private boolean IsBipartite = true;
  private boolean[] color;
  private boolean[] visited;
  public boolean possibleBipartition(int n, int[][] dislikes) {
      color = new boolean[n + 1];//Since the number starts from 1
      visited = new boolean[n + 1];
      List<Integer>[] graph = buildGraph(n, dislikes);
    for (int i = 1; i <= n ; i++) {
      if(!visited[i]){
        traverse(graph,i);
      }

    }
    return IsBipartite;
  }

  /**
   * Since we are using un-directed graphs for bipartition, there would be a little difference on
   * from and to
   * @param n
   * @param dislikes
   * @return
   */
  List<Integer>[] buildGraph(int n, int[][] dislikes){
    //Initialize the arraylist array
    List<Integer>[] graph = new ArrayList[n + 1];
    for (int i = 1; i <= n; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] ints : dislikes) {
      int from = ints[1];
      int to = ints[0];
      graph[from].add(to);
      graph[to].add(from);
    }
    return graph;

  }
  public void traverse(List<Integer>[] graph, int v){
    //First we should notice that if 'Is_Bipartite' is already false, we don;t have to  execute the rest of the code.
    if(!IsBipartite){
      return;
    }
    visited[v] = true;
    for (int x : graph[v]) {
      if(!visited[x]){
        color[x] = !color[v];

        traverse(graph, x);
      }else{//we should check if the existing color is different
        if(color[x] == color[v]){
          IsBipartite = false;
          return;
        }
      }
    }

  }

}
