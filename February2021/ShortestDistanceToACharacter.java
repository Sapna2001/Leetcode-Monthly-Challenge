/*

Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the shortest distance from s[i] to the 
character c in s.

Link - https://leetcode.com/explore/challenge/card/february-leetcoding-challenge-2021/584/week-1-february-1st-february-7th/3631/

*/

class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] answer = new int[s.length()];
        int previous = Integer.MIN_VALUE/2;
        // left to right
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i)==c)
                previous = i;
            answer[i] = i - previous; 
        }
        previous = Integer.MAX_VALUE/2;
        // right to left
        for(int i = s.length()-1 ; i >= 0 ; i--) {
            if(s.charAt(i)==c)
                previous = i;
            answer[i] = Math.min(answer[i],previous-i);
        }
        return answer;
    }
}


