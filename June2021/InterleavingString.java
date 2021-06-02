/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3765/
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        return isInterLinked(s1,0,s2,0,s3,"");
    }
    public boolean isInterLinked(String s1,int i,String s2,int j,String s3,String result) {
        if(result.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        
        boolean flag = false;
        if(i < s1.length())
            flag |= isInterLinked(s1,i+1,s2,j,s3,result+s1.charAt(i));
        if(j < s2.length())
            flag |= isInterLinked(s1,i,s2,j+1,s3,result+s2.charAt(j));
        return flag;
    }
}

// TLE

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        int[][] memo = new int[s1.length()][s2.length()];
        for(int i = 0 ; i < s1.length() ; i++) {
            for(int j = 0 ; j < s2.length() ; j++) {
                memo[i][j] = -1;
            }
        }
        return isInterLinked(s1,0,s2,0,s3,0,memo);
    }
    public boolean isInterLinked(String s1,int i,String s2,int j,String s3,int k,int[][] memo) {
        if(i == s1.length())
            return s2.substring(j).equals(s3.substring(k));
        if(j == s2.length())
            return s1.substring(i).equals(s3.substring(k));
        if(memo[i][j] > -1)
            return memo[i][j] == 1 ? true : false;
        
        boolean flag = false;
        if((s3.charAt(k) == s1.charAt(i) && isInterLinked(s1,i+1,s2,j,s3,k+1,memo))|| (s3.charAt(k) == s2.charAt(j) && isInterLinked(s1,i,s2,j+1,s3,k+1,memo)))
            flag = true;
        memo[i][j] = flag ? 1 : 0;
        return flag;
    }
}


