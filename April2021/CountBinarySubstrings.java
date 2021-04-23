/*
Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these 
substrings are grouped consecutively.

Substrings that occur multiple times are counted the number of times they occur.
Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/596/week-4-april-22nd-april-28th/3718/
*/

class Solution {
    public int countBinarySubstrings(String s) {
        int current = 1, previous = 0, result = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i)==s.charAt(i-1))
                current++;
            else {
                previous = current;
                current = 1;
            }
            if(previous >= current)
                result++;
        }
        return result;
    }
}

// TC : O(n)
