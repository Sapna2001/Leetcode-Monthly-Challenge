/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Link: https://leetcode.com/problems/unique-paths/
*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];  
        return helperMethod(m, n, dp);
    }
    
    private int helperMethod(int m, int n, int[][] dp) {
        if(m < 1 || n < 1) {
            return 0;
        }
        
        if(m == 1 && n == 1) {
            return 1;
        }
        
        if(dp[m][n] != 0) {
            return dp[m][n];
        }
        
        dp[m][n] = helperMethod(m, n - 1, dp) + helperMethod(m - 1, n, dp);
        return dp[m][n];
    }
}
