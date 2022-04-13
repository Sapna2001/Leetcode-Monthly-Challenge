/*
Given a positive integer n, generate an n x n matrix filled with elements from 1 to n^2 in spiral order.

Link: https://leetcode.com/problems/spiral-matrix-ii/
*/

class Solution {
    
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int minRow = 0, maxRow = n - 1, minCol = 0, maxCol = n - 1, totalElements = n *n, num = 1;
        while(num <= totalElements) {
            for(int i = minCol ; i <= maxCol && num <= totalElements; i++) {
                result[minRow][i] = num++;   
            }
            minRow++;
            
            for(int i = minRow ; i <= maxRow && num <= totalElements; i++) {
                result[i][maxCol] = num++;   
            }
            maxCol--;
            

            for(int i = maxCol ; i >= minCol && num <= totalElements; i--) {
                result[maxRow][i] = num++;   
            }
            maxRow--;
            
            
            for(int i = maxRow ; i >= minRow && num <= totalElements; i--) {
                result[i][minCol] = num++;   
            }
            minCol++;
            
        }
        
        return result;
    }
}

