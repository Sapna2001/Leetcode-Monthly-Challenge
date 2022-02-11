/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Link: https://leetcode.com/problems/permutation-in-string/
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        
        int[] s1Hash = new int[26];
        int[] s2Hash = new int[26]; 
        
        for(int i = 0 ; i < s1.length() ; i++) {
            s1Hash[s1.charAt(i) - 'a']++;
            s2Hash[s2.charAt(i) - 'a']++;
        }
        
        int count = 0;
        
        for(int i = 0 ; i < 26 ; i++) {
            if(s1Hash[i] == s2Hash[i]) {
                count++;
            }
        }
        
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int right = s2.charAt(i + s1.length()) - 'a', left = s2.charAt(i) - 'a';
            if (count == 26) {
                return true;
            }
            
            s2Hash[right]++;
            
            if(s2Hash[right] == s1Hash[right]) {
                count++;
            } else if(s2Hash[right] == s1Hash[right] + 1) {
                count--;
            }
            
            s2Hash[left]--;
            if(s2Hash[left] == s1Hash[left]) {
                count++;
            } else if(s2Hash[left] == s1Hash[left] - 1) {
                count--;
            }
        }
        
        return count == 26;
    }
}
