/*
You are given a rows x cols matrix grid representing a field of cherries where grid[i][j] represents the number of cherries that you can collect from the (i, j) cell.

You have two robots that can collect cherries for you:
- Robot #1 is located at the top-left corner (0, 0), and
- Robot #2 is located at the top-right corner (0, cols - 1).

Return the maximum number of cherries collection using both robots by following the rules below:

- From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
- When any robot passes through a cell, It picks up all cherries, and the cell becomes an empty cell.
- When both robots stay in the same cell, only one takes the cherries.
- Both robots cannot move outside of the grid at any moment.
- Both robots should reach the bottom row in grid.

Link: https://leetcode.com/problems/cherry-pickup-ii/submissions/
*/

class Solution {
    private int dfs(int[][] grid, Integer[][][] dp, int m, int n, int row, int col1, int col2) {
        if(row < 0 || row >= m || col1 < 0 || col1 >= n || col2 < 0 || col2 >= n) {
            return 0;
        }    
        
        if(dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }
        
        int maxCherries = 0;
        for(int i = -1 ; i <= 1 ; i++) {
            for(int j = -1 ; j <= 1; j++) {
                int newCol1 = col1 + i, newCol2 = col2 + j;
                maxCherries = Math.max(maxCherries, dfs(grid, dp, m, n, row + 1, newCol1, newCol2));
            }
        }
        
        int currentCherry = 0;
        if(col1 == col2) {
            currentCherry = grid[row][col1];
        } else {
            currentCherry = grid[row][col1] + grid[row][col2];    
        }
        
        dp[row][col1][col2] = currentCherry + maxCherries;
        return dp[row][col1][col2];
    }
    
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        Integer[][][] dp = new Integer[m][n][n];
        
        return dfs(grid, dp, m, n, 0, 0, n  - 1);
    }
}

/*
Time Complexity: O(n * m * m)
Space Complexity: O(n * m * m)
*/
