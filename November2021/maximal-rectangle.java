/*
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Link: https://leetcode.com/problems/maximal-rectangle/
*/

class Solution {
    private int maximalRectangleHelper(char[][] matrix, int row, int col) {
        int small, big;
        boolean isColumnSmall;
        if(row > col) {
            small = col; 
            big = row;
            isColumnSmall = true;
        } else {
            small = row;
            big = col;
            isColumnSmall = false;    
        }
        
        int[] height = new int[small];
        int maxRectangle = 0;
        
        for(int i = 0 ; i < big ; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for(int j = 0 ; j <= small ; j++) {
                if (j < small) {
                    if (isColumnSmall) {
                        height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
                    } else {
                        height[j] = matrix[j][i] == '0' ? 0 : height[j] + 1;
                    }
                }
                
                while (!stack.isEmpty() && (j == small || height[stack.peek()] >= height[j])) {
                    int h = height[stack.pop()];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    maxRectangle = Math.max(maxRectangle, (j - 1 - left) * h);
                }
                stack.push(j);
            }
        }
        
        return maxRectangle; 
    }
    
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length, col = matrix[0].length; 
        
        return maximalRectangleHelper(matrix, row, col);
    }
}
