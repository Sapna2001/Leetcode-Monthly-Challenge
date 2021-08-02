/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

Link: https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3835/

TC: O(n^2)
*/

class Solution {
    public int largestIsland(int[][] grid) {
        // id, area
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        int n = grid.length;
        int gridId = 2;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) {
                    int size = assignIdAndReturnArea(grid, i, j, gridId);
                    map.put(gridId,size);
                    gridId++;
                }
            }
        }
        
        int res = map.getOrDefault(2,0);
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < n - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < n - 1 ? grid[i][j + 1] : 0);
                    int totalArea = 1; 
                    for (int id : set) 
                        totalArea += map.get(id);
                    res = Math.max(res, totalArea);
                }
            }
        }
        
        return res;
    }
    
    int assignIdAndReturnArea(int[][] grid, int i, int j, int id) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)  
            return 0;
        grid[i][j] = id;
        return 1 + assignIdAndReturnArea(grid, i + 1, j, id) + assignIdAndReturnArea(grid, i - 1, j, id) + assignIdAndReturnArea(grid, i, j + 1, id) + assignIdAndReturnArea(grid, i, j - 1, id);
  }
}
