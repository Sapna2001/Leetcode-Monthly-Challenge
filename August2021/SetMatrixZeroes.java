/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's, and return the matrix.

You must do it in place.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3888/

TC : O(m*n)
SC : O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) 
            return;
        
        int m = matrix.length, n = matrix[0].length;
        
        boolean firstRowZero = false, firstColZero = false;
        
        for(int i = 0 ; i < n ; i++) {
            if(matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }
        
        for(int i = 0 ; i < m ; i++) {
            if(matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j < n ; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int j = 1 ; j < n ; j++) {
            if(matrix[0][j] == 0) {
                nullifyCol(matrix,j,m,n);
            }
        }
        
         for(int i = 1 ; i < m ; i++) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix,i,m,n);
            }
        }
         
        if(firstRowZero) {
            nullifyRow(matrix,0,m,n);
        }
        
        if(firstColZero) {
            nullifyCol(matrix,0,m,n);
        }
    }
    
    public void nullifyRow(int[][] matrix, int i, int m, int n) {
        for(int col = 0 ; col < n ; col++)
            matrix[i][col] = 0;
    }
    
    public void nullifyCol(int[][] matrix, int j, int m, int n) {
        for(int row = 0 ; row < m ; row++)
            matrix[row][j] = 0;
        
    }
}
