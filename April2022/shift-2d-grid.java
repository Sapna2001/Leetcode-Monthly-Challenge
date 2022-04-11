/*
Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:
- Element at grid[i][j] moves to grid[i][j + 1].
- Element at grid[i][n - 1] moves to grid[i + 1][0].
- Element at grid[m - 1][n - 1] moves to grid[0][0].

Return the 2D grid after applying shift operation k times.

Link: https://leetcode.com/problems/shift-2d-grid/
*/

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][] temp = grid;
        
        k %= (m * n);
        while(k-- > 0) {
            temp = new int[m][n];
            for(int i = 0 ; i < m ; i++) {
                for(int j = 1 ; j < n ; j++) {
                    temp[i][j] = grid[i][j - 1];
                }
            }
            
            for (int i = 1; i < m; i++) {
                temp[i][0] = grid[i - 1][n - 1];
            }
            
            temp[0][0] = grid[m - 1][n - 1];
            grid = temp;
        }
        
        List<List<Integer>> result = (List)Arrays.asList(temp);
        return result;
    }
}

/*
Time Complexity: O(k * m * n)
Space Complexity: O(m * n)
*/
