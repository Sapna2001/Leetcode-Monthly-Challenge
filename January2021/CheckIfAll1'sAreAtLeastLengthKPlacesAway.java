/*

Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False

Link - https://leetcode.com/explore/challenge/card/january-leetcoding-challenge-2021/582/week-4-january-22nd-january-28th/3616/

*/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int prevIndex = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 1) {
                if(prevIndex != Integer.MIN_VALUE && i-prevIndex-1<k)
                    return false;
                prevIndex = i;
            }
        }
        return true;
    }
}
