/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/637/week-2-september-8th-september-14th/3974/
*/

class Solution {
    public String reverseOnlyLetters(String s) {
        char[] c = s.toCharArray();
        int start = 0, end = s.length() - 1;
        
        while(start < end) {
            if(!isCharacter(c[start])) {
                start++;
                continue;
            }
            
            if(!isCharacter(c[end])) {
                end--;
                continue;
            }
            
            swap(c, start, end);
            start++;
            end--;
        }
        
        return new String(c);
    }
    
    private boolean isCharacter(char c) {
        return Character.isUpperCase(c) || Character.isLowerCase(c);
    }
    
    private void swap(char[] c, int start, int end) {
        char temp = c[start];
        c[start] = c[end];
        c[end] = temp;
    }
}

/*
TC: O(n)
SC: O(1)
*/
