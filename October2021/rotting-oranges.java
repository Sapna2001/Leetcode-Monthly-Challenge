/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Link: https://leetcode.com/problems/rotting-oranges/
*/

class Solution {

    private class Point {
        private int x;
        private int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
   
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if(n == 0 || m == 0){
            return -1;
        }

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2){
                    queue.offer(new Point(i, j));
                }
            }
        }

        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0){
                Point head = queue.poll();
                int i = head.x;
                int j = head.y;

                if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] <= 0){
                    continue;
                }
                
                grid[i][j] = -1;

                if(i >= 1 && grid[i-1][j] == 1){
                    grid[i-1][j] = 3; 
                    queue.offer(new Point(i-1,j));
                }


                if(i<n-1 && grid[i+1][j]==1){
                    grid[i+1][j] = 3;
                    queue.offer(new Point(i+1,j));
                }

                if(j>=1 && grid[i][j-1]==1){
                    grid[i][j-1] = 3; 
                    queue.offer(new Point(i,j-1));
                }



                if(j<m-1 && grid[i][j+1]==1){
                    grid[i][j+1] = 3; // 
                    queue.offer(new Point(i,j+1));
                }
            }
            level++;
        }


        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return level > 0 ? level-1 : 0;
    }
}
