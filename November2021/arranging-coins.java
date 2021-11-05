/*
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the 
staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

Link: https://leetcode.com/problems/arranging-coins/
*/

class Solution {
    public int arrangeCoins(int n) {
        int rowCount = 0;
        while(n > 0) {
            rowCount++;
            n -= rowCount;
        }
        return n == 0 ? rowCount : rowCount - 1;
    }
}
