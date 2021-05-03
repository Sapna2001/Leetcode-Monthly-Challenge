/*
Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int sumTillNow = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            sumTillNow += nums[i];
            nums[i] = sumTillNow;
        }
        return nums;
    }
}

// TC : O(n)
// SC : O(1)
