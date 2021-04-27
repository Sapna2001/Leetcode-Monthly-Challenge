/*
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3722/
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        double log = (Math.log10(n)/Math.log10(3));
        if(log - (int)log == 0)
            return true;
        return false;
    }
}

