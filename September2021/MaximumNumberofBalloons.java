/*
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3973/
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] charFrequency = new int[26];
        int min = Integer.MAX_VALUE;
        
        for(char c : text.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        
        char[] ballon = new char[]{'b', 'a', 'l', 'o', 'n'};
        
        for(char c : ballon) {
            if(c == 'l' || c == 'o')
                charFrequency[c - 'a'] =  charFrequency[c - 'a']/2;
            min = Math.min(min, charFrequency[c - 'a']);
        }
        
        min = min == Integer.MAX_VALUE ? 0 : min;
            
        return min;
    }
}
