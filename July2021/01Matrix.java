/*
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

 Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/612/week-5-july-29th-july-31st/3831/
 
 TC: O(n*m)
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0 ; i < mat.length ; i++) {
            for(int j = 0 ; j < mat[0].length ; j++) {
                if(mat[i][j] == 0) 
                    queue.add(new int[]{i,j});
                else
                    mat[i][j] = -1;
            }
        }
        
    int[][] directions = {{0,1}, {-1,0}, {1,0}, {0,-1}};
    int length = 0;
    while(!queue.isEmpty()) {
        int size = queue.size();
        length++;
        while(size-- > 0) {
            int[] cell = queue.poll();
            for(int[] direction: directions) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];
                if(row < 0 || col < 0 || row == mat.length || col == mat[0].length || mat[row][col] != -1)
                    continue;
                mat[row][col] = length;
                queue.add(new int[]{row,col});
            }
        }
    }
    return mat;
    }
}
