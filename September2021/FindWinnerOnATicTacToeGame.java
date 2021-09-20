/*
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/638/week-3-september-15th-september-21st/3981/
*/

class Solution {
    public static String checkBoard(char[][] board){

        // columns
        for(int j = 0; j < 3; j++){
            int countA = 0;
            int countB = 0;
            
            for(int i = 0; i < 3; i++){
                if(board[i][j] == 'X') 
                    countA ++;
                else if(board[i][j] == 'O') 
                    countB ++;
            }

            if(countA == 3) 
                return "A";
            
            if(countB == 3) 
                return "B";
        }

        // rows
        for(int j = 0; j < 3; j++){
            int countA = 0;
            int countB = 0;
            for(int i = 0; i < 3; i++){
                if(board[j][i] == 'X') 
                    countA ++;
                else if(board[j][i] == 'O') 
                    countB ++;
            }

            if(countA == 3) 
                return "A";
            
            if(countB == 3) 
                return "B";
        }

        // left diagonal
        if(board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') 
            return "A";
        
        if(board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') 
            return "B";

        // right diagonal
        if(board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') 
            return "A";
        
        if(board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') 
            return "B";

        // draw
        int count = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == 'X' || board[i][j] == 'O') {
                    count++;
                }
            }
        }

        if(count != 9) 
            return "Pending";

        return "Draw";
    }

    public String tictactoe(int[][] moves) {

        int n = moves.length;
        char[][] board = new char[3][3];
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }

        for(int i = 0; i < n; i++){
            if(i % 2 == 0){ // => A
                board[moves[i][0]][moves[i][1]] = 'X';
            } else{ // B
                board[moves[i][0]][moves[i][1]] = 'O'; 
            }
        }

        return checkBoard(board);
    }
}
