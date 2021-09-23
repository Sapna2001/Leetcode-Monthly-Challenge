/*
Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/639/week-4-september-22nd-september-28th/3985/

TC: O(n)
SC: O(n)
*/

class Solution {
    public String breakPalindrome(String palindrome) {
        char[] chStr = palindrome.toCharArray();
        if(chStr.length < 2) {
            return "";
        }
        
        for(int i = 0 ; i < chStr.length/2 ; i++) {
            if(chStr[i] != 'a') {
                chStr[i] = 'a';
                return String.valueOf(chStr);
            }
        }
        
        // if all the characters are a
        chStr[chStr.length - 1] = 'b';
            
        return String.valueOf(chStr);
    }
} 
