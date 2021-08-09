/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers 
directly.

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/614/week-2-august-8th-august-14th/3875/
*/

class Solution {
    public String addStrings(String num1, String num2) {
        String result = "";
        int num1Length = num1.length() - 1;
        int num2Length = num2.length() - 1;
        int sum = 0, carry = 0;
        
        while(num1Length >= 0 && num2Length >= 0) {
            int digit1 = num1.charAt(num1Length) - '0';  
            int digit2 = num2.charAt(num2Length) - '0'; 
            sum = digit1 + digit2 + carry;
            carry = sum/10;
            sum = sum % 10;
            result = sum + result;
            num1Length--;
            num2Length--;
        }
        
        while(num1Length >= 0) {
           int digit1 = num1.charAt(num1Length) - '0';   
           sum = digit1 + carry;
           carry = sum/10;
           sum = sum % 10;
           result = sum + result;
           num1Length--;
        }
        
        while(num2Length >= 0) {
           int digit2 = num2.charAt(num2Length) - '0';   
           sum = digit2 + carry;
           carry = sum/10;
           sum = sum % 10;
           result = sum + result;
           num2Length--;
        }
        
        if(carry == 1)
            result = "1" + result;
        
        return result;
    }
}
