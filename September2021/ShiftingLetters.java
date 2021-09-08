/*
You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3968/

TC: O(n)
SC: O(n)
*/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] str = s.toCharArray();
        int shift = 0;
        
        for(int i = shifts.length - 1 ; i >= 0 ; i--) {
            shift = (shift + shifts[i]) % 26;
            str[i] = (char)((str[i] - 'a' + shift) % 26 + 'a');
        } 
        
        return new String(str);
    }
}


