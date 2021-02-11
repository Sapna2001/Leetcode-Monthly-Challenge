/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/585/week-2-february-8th-february-14th/3636/
// hashtable can also be used
// use hashmap for the unicode solution
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        char sArray[] = s.toCharArray();
        Arrays.sort(sArray);
        char tArray[] = t.toCharArray();
        Arrays.sort(tArray);
        return Arrays.equals(sArray,tArray);
    }
}
