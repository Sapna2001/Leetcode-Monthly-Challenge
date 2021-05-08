/*
Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.

Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/599/week-2-may-8th-may-14th/3736/
*/

class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromicNumbers = new ArrayList<>();
        Long leftNumber = Long.parseLong(left);
        Long rightNumber = Long.parseLong(right);
        int count = 0;
        
        for(long i = 1 ; i < 10 ; i++) 
            palindromicNumbers.add(i);
        
        // left Part and right Part is upto 10^4
        for(long i = 1 ; i < 10000 ; i++) {
            String leftPart = Long.toString(i);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            palindromicNumbers.add(Long.parseLong(leftPart+rightPart));
            for(int digit = 0 ; digit < 10 ; digit++)
                palindromicNumbers.add(Long.parseLong(leftPart + digit + rightPart)); // 10^9
        }
        
        // check the condition
        for(long number : palindromicNumbers) {
            long squareNumber = number * number; // 10^18
            if(squareNumber >= leftNumber && rightNumber >= squareNumber && isPalindrome(Long.toString(squareNumber)))
                count++;
        }
        return count;
    }
    
    public boolean isPalindrome(String number) {
        int start = 0;
        int end = number.length()-1;
        while(start < end) {
            if(number.charAt(start) != number.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}
