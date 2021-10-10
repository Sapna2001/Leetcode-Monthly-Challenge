/*
Given two integers left and right that represent the range [left, right], return the bitwise AND of all numbers in this range, inclusive.

Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/
*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // int ans = left;
        // for(int i = left ; i <= right ; i++) {
        //     ans &= i;
        // }
        // return ans;
        
        int shiftCount = 0;
        while(left != right) {
            left >>= 1;
            right >>= 1;
            shiftCount++;
        }
        
        return left << shiftCount;
    }
}
