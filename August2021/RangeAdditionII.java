/*
You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 
0 <= x < ai and 0 <= y < bi.

Count and return the number of maximum integers in the matrix after performing all the operations.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/617/week-5-august-29th-august-31st/3957/
*/

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minRow = m , minCol = n;  
        for(int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        
        return minRow * minCol;
    }
}

// TC: O(ops.length)
// SC: O(1)

 
