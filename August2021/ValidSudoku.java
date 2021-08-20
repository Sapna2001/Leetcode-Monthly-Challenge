/*
Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3904/
TC: O(1)
SC: O(N)
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> visited = new HashSet();
        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j < 9 ; j++) {
                char number = board[i][j];
                if(number != '.') {
                    if( visited.contains(number + "_R_" + i) ||
                        visited.contains(number + "_C_" + j) ||
                        visited.contains(number + "_B_" + i/3 + j/3))
                        return false;
                    else {
                        visited.add(number + "_R_" + i);
                        visited.add(number + "_B_" + i/3 + j/3);
                        visited.add(number + "_C_" + j);
                    }
                }
            }
        }
        return true;
    }
}
