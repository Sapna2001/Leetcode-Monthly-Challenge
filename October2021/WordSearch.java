/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell 
may not be used more than once.

Link: https://leetcode.com/problems/word-search/
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(charArray[0] == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(board, charArray, i, j, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, char[] word, int i, int j, boolean[][] visited, int index) {
        if(index == word.length) {
            return true;
        }
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return false;
        }
        
        if(board[i][j] != word[index]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if((dfs(board, word, i + 1, j, visited, index + 1)) || 
           (dfs(board, word, i, j + 1, visited, index + 1)) ||
           (dfs(board, word, i - 1, j, visited, index + 1)) ||
           (dfs(board, word, i, j - 1, visited, index + 1))) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
