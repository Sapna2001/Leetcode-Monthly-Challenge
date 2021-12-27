/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.

For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer num, return its complement.

Link: https://leetcode.com/problems/number-complement/
*/

class Solution {
    public int findComplement(int num) {
        int largestNumber = 0, power = 0;
        while(largestNumber < num) {
            largestNumber += Math.pow(2, power++);    
        }
        
        int result = largestNumber - num;
        return result; 
    }
}
