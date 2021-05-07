/*
Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3734/

Minimum deletion required = str1.len + str2.len - 2*(length of longest common subsequence)
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int lengthLongestCommonSubsequence = getLengthCommonSubSequence(word1,word2);
        return word1.length() + word2.length() - (2*lengthLongestCommonSubsequence);
    }
    public int getLengthCommonSubSequence(String s1, String s2) {
        int[][] dp =  new int[s1.length()+1][s2.length()+1];
        for(int i = 1 ; i <= s1.length() ; i++) {
            for(int j = 1 ; j <= s2.length() ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

// TC : O(m*n)
// SC : O(m*n)
