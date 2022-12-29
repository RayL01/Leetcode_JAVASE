package com.shady.Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/28/21:29
 * @Description:
 * All Paths From Source to Target
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 */
public class AllPathsFromSourcetoTarget {
  public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    traverse(graph,0, res, path);
    return res;
  }
  public void traverse(int[][] graph, int n,  List<List<Integer>> res, List<Integer> path){
    path.add(n);
    int m = graph.length;
    if(n == m - 1){
      //it has reached the end
      //Since res store the address of path, and if path changes, the path in the res also changes,
      //so we should create a new object duplicated from path to ensure the invariance.
      res.add(new ArrayList<>(path));

    }
    for (int s : graph[n]) {
      traverse(graph, s, res, path);
    }
    path.remove(path.size() - 1);

  }
  @Test
  public void test(){
    int[][] graph = {{1,2},{3},{3},{}};
    allPathsSourceTarget(graph);
  }
}
