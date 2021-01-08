/*
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

Link : https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/580/week-2-january-8th-january-14th/3597/
*/

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		String array1 = new String(""); 
        String array2 = new String("");  
        for(int i=0;i<word1.length;i++)
            array1+=word1[i];
        for(int i=0;i<word2.length;i++)
            array2+=word2[i];
        return array1.equals(array2);
    }
}
