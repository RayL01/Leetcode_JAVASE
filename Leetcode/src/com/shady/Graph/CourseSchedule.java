package com.shady.Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
  public boolean canFinish_BFS(int numCourses, int[][] prerequisites){
      List<Integer> graph[] = buildGraph(numCourses,prerequisites);
      int[] indegree = new int[numCourses];
      for(int[] edge : prerequisites){
        int from = edge[1];
        int to = edge[0];
        indegree[to]++;
      }

      //Then we should traverse the tree in a Queue.
      Queue<Integer> queue = new LinkedList<>();
      //Next, we should find the starting point(indegree = 0)

      for (int i = 0; i < numCourses; i++) {
          if(indegree[i] == 0 ){
            queue.offer(i);
          }
      }

      //Record the number of visited nodes
      int count = 0;

      //BFS
    while(!queue.isEmpty()){
      int cur = queue.poll();
      count++;
      //Then we should decrease the indegree of its neighbors
      for (int x :graph[cur]
           ) {
        indegree[x]--;
        if(indegree[x] == 0){
          queue.offer(x);
        }
      }
    }

    //after BFS, if there are nodes left unvisited, it indicates a circle
    return count == numCourses;


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
