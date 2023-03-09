package com.shady.Graph.DFS_Islands;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 * Calculate the number of cells(area) instead of number of islands in the grid
 */
public class NumberOfEnclaves {
    public int numEnclaves(int[][] grid) {
        //nodes at the edge of the grid would no longer be considered as islands
        //In addition, adjacent nodes to it will not be considered as islands either.
        //Therefore, we should flood nodes at edges of the grid
        int m = grid.length;
        int n = grid[0].length;
        int area = 0;
        for (int j = 0; j < n; j++) {
            //Flood the top edge and its continuous islands nodes
            dfs(grid,0,j);
            //Flood the bottom edge and its continuous islands nodes
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            //Flood the left edge and its continuous islands nodes
            dfs(grid, i, 0);
            //Flood the right edge and its continuous islands nodes
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 1){
                    area++;

                }

            }

        }
        return area;
    }
    private void dfs(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || j < 0 || i >= m || j >= n) return;

        if ( grid[i][j] == 0) return;

        grid[i][j] = 0;

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j );
        dfs(grid, i, j + 1);
        dfs(grid, i , j - 1);
    }
}
