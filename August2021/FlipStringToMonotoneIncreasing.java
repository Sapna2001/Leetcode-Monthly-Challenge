/*
A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3876/

TC: O(n)
SC: O(1)
*/

class Solution {
    public int minFlipsMonoIncr(String s) {
        int flip = 0, count1 = 0, i=0; 
        while(i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        for( ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == '0') {
               flip++; 
            } else {
               count1++; 
            }
            flip = Math.min(flip,count1);
        }
        return flip;
    }
}

