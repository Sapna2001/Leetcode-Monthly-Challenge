/*

Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Link - https://leetcode.com/explore/featured/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3625/

*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n!=0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
