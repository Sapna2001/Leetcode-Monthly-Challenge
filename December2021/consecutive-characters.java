/*
The power of the string is the maximum length of a non-empty substring that contains only one unique character.

Given a string s, return the power of s.

Link: https://leetcode.com/problems/consecutive-characters/
*/

class Solution {
    public int maxPower(String s) {
        if(s.length() == 0) {
            return 0;
        }   
        
        int maxLength = 1, count = 1;
        
        for(int i = 1 ; i < s.length() ; i++) {
            if(s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            
            maxLength = Math.max(count, maxLength);
        }
        
        return maxLength;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
