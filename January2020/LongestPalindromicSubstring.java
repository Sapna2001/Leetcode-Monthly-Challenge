/*
Given a string s, return the longest palindromic substring in s.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3609/
*/

class Solution {
    int max = 0, start = 0;
    public String longestPalindrome(String s) {
        for(int i=0 ; i<s.length(); i++) {
            // odd case
            checkpalindrome(s,i,i);
            // even case
            checkpalindrome(s,i,i+1);
        }
        return s.substring(start,start+max);
    }
    
    public void checkpalindrome(String s,int left,int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        if(len>max) {
            max = len;
            start = left+1;
        }
    }
}
