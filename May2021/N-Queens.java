/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3752/
*/

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList <List<String>>();
        char[][] chess = new char[n][n];
        
        for(int i = 0; i < n ; i++)
            for(int j = 0; j < n ; j++)
                chess[i][j] = '.';
        
        placeQueens(ans, chess, 0);
        return ans;
    }
    
    private void placeQueens(List<List<String>> ans, char[][] chess, int row) {
        if(row == chess.length) {
            ans.add(build(chess));
            return;
        }
        
        for(int col = 0 ; col < chess.length ; col++) {
            if(valid(chess,row,col)) {
                chess[row][col] = 'Q';
                placeQueens(ans, chess, row + 1);
                chess[row][col] = '.';
            }
        }
    }
    
    private boolean valid(char[][] chess, int row, int col) {
        for(int i = 0; i < row; i++)
            if(chess[i][col] == 'Q')
                return false;
        
        // 45 degree
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++)
            if(chess[i][j] == 'Q')
                return false;
        
        // 135 degree
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if(chess[i][j] == 'Q')
                return false;
        
        return true;
    }
    
    private List<String> build(char[][] chess) {
        List<String> path = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) 
            path.add(new String(chess[i]));
        return path;
    }
}
