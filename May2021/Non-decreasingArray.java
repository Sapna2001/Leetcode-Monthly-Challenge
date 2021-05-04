/*
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2)

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3731/
*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        int modification = 0;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i-1] > nums[i]) {
                modification++;
            if(i>=2 && nums[i-2]> nums[i])   
                nums[i] = nums[i-1];
            else
                nums[i-1] = nums[i];
            }   
        }
         return modification <= 1;
    }
}
