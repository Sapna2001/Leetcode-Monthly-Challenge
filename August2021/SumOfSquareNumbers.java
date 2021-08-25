/*
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/616/week-4-august-22nd-august-28th/3918/

TC: O(sqrt(c) logc)
SC: O(1)
*/

public class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
}


