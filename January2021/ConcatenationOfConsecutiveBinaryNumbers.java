/*
Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3618/
 */
 
 class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1000000007,res=0,power=1;  
        
        for(int i = n ; i > 0 ; i--) {
            int no = i;
            while(no!=0) {
               if((no&1)!=0) {
                   res= (res+power)%MOD;
               }
                power = (power*2)%MOD;
                no = no>>1;
           } 
        }
        return res%MOD;
    }
}
