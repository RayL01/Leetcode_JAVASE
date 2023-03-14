package com.shady.Graph.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shadyyyyyl
 * @Date: 2023/03/14/00:12
 * @Description: Sliding puzzle solved by BFS
 * https://leetcode.com/problems/sliding-puzzle/
 */
public class SlidingPuzzle {
  public int slidingPuzzle(int [][] board){
    int m = board.length;
    int n = board[0].length;
    String target = "123450";
    //First we convert the initial state of the board to  a sting
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(board[i][j]);
      }
    }
    String start = sb.toString();

    //We convert the 2-d array to 1d so that we can better figure out the neighbors of the current node
    int [][] neighbor = new int[][]{
            {1,3},  //Here it's the index in the one d array
            {0,4,2},
            {1,5},
            {0,4},
            {3,1,5},
            {4,2}
            /**
             * Neighbor[4] = {1,3,5}, it means 4, 5, 3 are 0's neighbors
             *
            */
    };

    //Start of the BFS framework
    int step = 0;
    Queue<String> queue = new LinkedList<>();
    HashSet<String> visited = new HashSet<>();


    queue.offer(start);
    visited.add(start);

    while(!queue.isEmpty()){
      int size = queue.size();
      for (int i = 0; i < size; i++) {

        String cur = queue.poll();
        if(cur.equals(target)){
          return step;
        }
        //Then we should find the neighbors of '0'.
        //But first, we should find the index of '0'
        int index = 0;
        for (;cur.charAt(index) != '0'; index++);
        //after the for loop, index is at the right position
        for (int x:neighbor[index]
             ) {
          String new_board = swap(cur, index, x);

          //Check the visited
          if(!visited.contains(new_board)){
            queue.offer(new_board);
            visited.add(new_board);
          }
        }

      }
      step++;
    }
    return -1;//No way to the target.
  }

  /**
   * Since String is immutable, we should convert string to a char array for swapping
   * @return and convert the char array to a string in the end
   */
  private String swap(String s, int a, int b){
    char[] chars = s.toCharArray();
    char tmp = chars[a];
    chars[a] = chars[b];
    chars[b] = tmp;
    return new String(chars);
  }
}
