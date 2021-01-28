/*

Determine if Two Strings Are Close  

Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Link - https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3613/
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        
        int[] f1 = new int[26];
        int[] f2 = new int[26];
        boolean[] v1 = new boolean[26];
        boolean[] v2 = new boolean[26];
        
        for(int i=0 ; i<word1.length();i++) {
            f1[word1.charAt(i)-'a']++;
            f2[word2.charAt(i)-'a']++;
            v1[word1.charAt(i)-'a'] = true;
            v2[word2.charAt(i)-'a'] = true;
        }
        
        Arrays.sort(f1);
        Arrays.sort(f2);
        
        return Arrays.equals(f1,f2) && Arrays.equals(v1,v2);
    }
}
