/*

A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the 
matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3614/

*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0; j < n ; j++) {
                int diagonalKey = i - j;
                PriorityQueue<Integer> priorityQueue = map.getOrDefault(diagonalKey, new PriorityQueue<>());
                priorityQueue.offer(mat[i][j]);
                map.put(diagonalKey, priorityQueue);
            }
        }
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
               int diagonalKey = i - j;
               PriorityQueue<Integer> priorityQueue = map.get(diagonalKey);
                mat[i][j] = priorityQueue.poll();
            }
        }
        
        return mat;
        // TC : O(m*n * log(D)) , D stand min(m, n)
       // SC: O(m*n)
    }
}
