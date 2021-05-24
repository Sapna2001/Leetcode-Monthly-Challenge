/*
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3754/
*/

class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i)>='A' && 'Z' >= s.charAt(i)) {
                char ch = (char)(s.charAt(i)+32);
                sb.setCharAt(i , ch);
            }
        } 
        return sb.toString();
    }
}
