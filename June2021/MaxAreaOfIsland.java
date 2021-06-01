/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all 
four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Link: https://leetcode.com/explore/featured/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3764/
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int maxArea = 0;
        int currentArea = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    currentArea = bfs(grid,i,j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }
    
    private int bfs(int[][] grid, int k, int l) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{k,l});
        int result = 0;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            result++;
            final int[][] neighbours = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for(int[] neighbour : neighbours) {
                int i = current[0] + neighbour[0];
                int j = current[1] + neighbour[1];
                if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
                    grid[i][j] = 0;
                    queue.offer(new int[]{i,j});
                }
            }
        }
        return result;
    }
}

