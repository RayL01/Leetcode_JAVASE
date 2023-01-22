package com.shady.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/29/23:46
 * @Description: Course Schedule 2      reverse postorder
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class CourseScheduleII {
  List<Integer> postorder = new ArrayList<>();
  boolean hasCycle = false;
  boolean visited[];
  boolean onPath[];
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    //Initialization
    List<Integer> [] graph = buildGraph(numCourses, prerequisites);
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      traverse(graph, i);
    }
    //if there is a cycle, topological sort can't be executed
    if(hasCycle){
      return new int[]{};
    }
    //The reversing order of the postorder is the answer
    Collections.reverse(postorder);
    int[] res = new int[numCourses];
    for (int i = 0; i < postorder.size(); i++) {
        res[i] = postorder.get(i);
    }
    return res;

  }
  List<Integer> [] buildGraph(int numCourses, int[][] prerequisites){
    List<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] s: prerequisites ) {
      int from = s[1];
      int to = s[0];
      graph[from].add(to);
    }
    return graph;

  }
  void traverse(List<Integer>[] graph, int i){
    if(onPath[i]){
      hasCycle = true;
    }
    if(hasCycle || visited[i]){
      return;
    }
    //preorder
    visited[i] = true;
    onPath[i] = true;

    for(Integer j : graph[i]){
      traverse(graph, j);
      String s;
    }

  }
}
