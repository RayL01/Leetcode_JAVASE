package com.shady.Graph.DFS_Islands;

import java.util.HashSet;

public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //User HashSet to filter out the same island
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    //Flood the island and save the traversal of location into the hashset
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j, sb, 100);

                    //Store the result
                    hashSet.add(sb.toString());
                }
            }

        }
        return hashSet.size();
    }
    private void dfs(int [][] grid, int i, int j, StringBuilder sb, int dir){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return;

        //pre-order traversal position : enter (i,j)
        grid[i][j] = 0;
        sb.append(dir).append(',');


        //Then we should use DFS to track the direction of the rest land nodes


        dfs(grid, i - 1, j, sb, 1);//top
        dfs(grid, i + 1, j, sb,2);//bottom
        dfs(grid, i, j - 1, sb, 3);//left
        dfs(grid, i , j + 1, sb, 4);//right

        //post-order traversal position: leaving (i,j) traversing backwards
        sb.append(-dir).append(',');


    }
}
