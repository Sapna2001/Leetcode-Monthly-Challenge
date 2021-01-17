/*
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the alphabet.

 
 Link :- https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/581/week-3-january-15th-january-21st/3607/
 
 */
 
 class Solution {
    public int countVowelStrings(int n) {
       int[] dp = new int[5];
        Arrays.fill(dp,1);
        for(int i=2;i<=n;i++) {
            for(int j=3;j>=0;j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }
        int ans = 0;
        for(int i : dp)
          ans+=i;  
        return ans;
    }
}

// TC:O(n)
// SC:(1)
