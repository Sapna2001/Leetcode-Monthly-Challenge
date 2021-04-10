/*
Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/594/week-2-april-8th-april-14th/3703/
*/

public class Solution {
    
    public static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) 
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n,dp);
                max = Math.max(max, len);
            }
        }   
        return max;
}

public int dfs(int[][] matrix, int i, int j, int m, int n,int[][] dp) {
    if(dp[i][j] != 0) 
        return dp[i][j];
    int max = 1;
    for(int[] direction: directions) {
        int x = i + direction[0], y = j + direction[1];
        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) 
            continue;
        int len = 1 + dfs(matrix, x, y, m, n,dp);
        max = Math.max(max, len);
    }
    dp[i][j] = max;
    return max;
    }
}
