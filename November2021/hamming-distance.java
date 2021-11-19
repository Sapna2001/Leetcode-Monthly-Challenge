/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Link: https://leetcode.com/problems/hamming-distance/
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int xLastBit = 0, yLastBit = 0, count = 0;
        while(x > 0 || y > 0) {
            xLastBit = x & 1;
            yLastBit = y & 1;
            
            if(xLastBit != yLastBit) {
                count++;
            }
            
            x = x >> 1;
            y = y >> 1;
        }
        
        return count;
    }
}
