/*
Given an m x n matrix, return all elements of the matrix in spiral order.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3977/

TC: O(mn)
SC: O(1)
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0, minCol = 0, maxRow = matrix.length - 1, maxCol = matrix[0].length - 1 , count = 0, 
            totalElements = ( matrix.length) *( matrix[0].length);
        
        List<Integer> result = new LinkedList<Integer>();
        
        while(count < totalElements) {
            // top
            for(int i = minCol ; i <= maxCol && count < totalElements; i++) {
                // System.out.println(matrix[minRow][i]);
				result.add(matrix[minRow][i]);
				count++;
			}
			minRow++;
            
            //right
            for(int i = minRow ; i <= maxRow && count < totalElements; i++) {
                // System.out.println(matrix[i][maxCol]);
				result.add(matrix[i][maxCol]);
				count++;
			}
			maxCol--;
            
            //bottom
            for(int i = maxCol ; i >= minCol && count < totalElements; i--) {
                // System.out.println(matrix[maxRow][i]);
				result.add(matrix[maxRow][i]);
				count++;
			}
			maxRow--;
            
            //left
            for(int i = maxRow ; i >= minRow && count < totalElements; i--) {
                // System.out.println(matrix[i][minCol]);
				result.add(matrix[i][minCol]);
				count++;
			}
			minCol++;
        }
        
        return result;
    }
}
