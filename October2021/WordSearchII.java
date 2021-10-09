/*
Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be 
used more than once in a word.

Link: https://leetcode.com/problems/word-search-ii/
*/

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> hashSet = new HashSet<>();
        int m = board.length, n = board[0].length;
        if(m == 0 || n == 0) {
            return new ArrayList<>();
        }
        
        for(String word : words) {
            for(int i = 0 ; i < m ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    boolean[][] visited = new boolean[m][n];
                    if(word.charAt(0) == board[i][j]) {
                        if(dfs(word, 0, i, j, visited, board)) {
                            hashSet.add(word);
                        }
                    }
                }
            }
        }
        
        return new ArrayList<>(hashSet);
    }
    
    private boolean dfs(String word, int length , int i, int j, boolean[][] visited, char[][] board) {
        if(length == word.length()) {
            return true;
        }
        
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || word.charAt(length) != board[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if(dfs(word, length + 1, i + 1, j, visited, board) ||
           dfs(word, length + 1, i - 1, j, visited, board) ||
           dfs(word, length + 1, i, j + 1, visited, board) ||
           dfs(word, length + 1, i, j - 1, visited, board)) {
            return true;
        }
            
        visited[i][j] = false;
        
        return false;
    }
}
