package com.shady.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2022/12/29/13:25
 * @Description: Circle detection
 * https://leetcode.com/problems/course-schedule/
 */
public class CourseSchedule {
  boolean[] visited;
  boolean[] onPath;
  boolean hasCyle = false;

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    visited = new boolean[numCourses];
    onPath = new boolean[numCourses];
    List<Integer>[] graph = buildGraph(numCourses,prerequisites);
    for (int i = 0; i < numCourses; i++) {
      traverse(graph, i);
    }
    return !hasCyle;

  }
  List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
    //Initialize the arraylist array
    List<Integer>[] graph = new ArrayList[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int[] ints : prerequisites) {
      int from = ints[1];
      int to = ints[0];
      graph[from].add(to);
    }
    return graph;

  }
  void traverse(List<Integer>[] graph, int i){
    if(onPath[i]){//The cycle is detected
      hasCyle = true;
    }
    if(hasCyle || visited[i]){
      return;
    }
    visited[i] = true;
    onPath[i] = true;
    for(Integer j : graph[i]){
      traverse(graph, j);
    }
    //after traverse, we will leave the node
    onPath[i] = false;
  }

}
