package com.shady.Graph.DFS_Islands;

/**
 * https://leetcode.com/problems/number-of-islands/editorial/
 *
 * Time: O(m * n)
 * Space: O(m *n)
 */
public class Num_OF_Islands {
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;

        //Traverse the grid to find the islands

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    //We find an island
                    res++;

                    //Then we should use DFS to food the contiguous nodes
                    dfs(grid, i, j);

                }
            }

        }
        return res;

    }
    void dfs(char [][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        //Check the out-bounding of index
        if(i < 0 || j < 0 || i >= m || j >= n){
            return;
        }

        if(grid[i][j] == '0'){
            return;
        }

        //Then we should flood the contiguous nodes
        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i , j + 1);
        dfs(grid, i , j - 1);

    }
}
