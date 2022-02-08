/*
Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Link: https://leetcode.com/problems/add-digits/
*/

class Solution {
    public int addDigits(int num) {
        int result = 0;
        while(num > 0) {
            int rem = num % 10;
            result += rem;
            num /= 10;
            
            if(num == 0 && result > 9) {
                num = result;
                result = 0;
            }
        }
        
        return result ;
    }
}
