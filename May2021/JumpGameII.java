/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/
*/

class Solution {
    public int jump(int[] nums) {
        int jumps = 0, currentPosition = 0, farthestIndex = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            farthestIndex = Math.max(farthestIndex, i + nums[i]);
            if(i == currentPosition) {
                jumps++;
                currentPosition = farthestPosition;
            }
        }
        return jumps;
    }
}

// TC : O(n)
