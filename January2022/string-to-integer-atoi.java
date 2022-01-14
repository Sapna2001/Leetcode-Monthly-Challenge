/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

Link: https://leetcode.com/problems/string-to-integer-atoi/
*/

class Solution {
    public int myAtoi(String s) {
        int n = s.length(), index = 0, result = 0, sign = 1;
        
        while(index < n && s.charAt(index) == ' ') {
            index ++;
        }
        
        if(index < n && s.charAt(index) == '-') {
	        sign = -1;  
	        index++;
	    } else if(index < n && s.charAt(index) == '+') {
	        index++;
	    }
               
        while((index < n) && (0 <= s.charAt(index) - '0') && (s.charAt(index) - '0' <= 9)) {
            int digit = s.charAt(index) - '0';  
            if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10) && digit > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        
        return result * sign;
    }
}
