/*
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land 
cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width
and height don't exceed 100. Determine the perimeter of the island.

Link: https://leetcode.com/problems/island-perimeter/
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1)
                    return dfs(grid, i, j, visited);
            }
        }
        
        return 0;
    }
    
    public int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 1;
        
        if(visited[i][j])
            return 0;
        
        visited[i][j] = true;
        
        return dfs(grid, i + 1, j, visited) +
               dfs(grid, i, j + 1, visited) +
               dfs(grid, i - 1, j, visited) +
               dfs(grid, i, j - 1, visited);
    }
}
