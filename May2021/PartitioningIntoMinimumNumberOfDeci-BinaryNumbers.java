/*
Given a string n that represents a positive decimal integer, return the minimum number of positive deci-binary numbers needed so that they sum up to n.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3756/
*/

class Solution {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n.length() ; i++) {
            int ch = Character.getNumericValue(n.charAt(i));
            max = Math.max(ch,max);
        }
        return max;
    }
}

/* 
TC : O(n)
SC: O(1)
*/

