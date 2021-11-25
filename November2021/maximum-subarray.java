/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

Link: https://leetcode.com/problems/maximum-subarray/
*/

class Solution {
    public int maxSubArray(int[] nums) {
        // if array has only 1 element
        if (nums.length == 1)
            return nums[0];
        
        // the maximum sum of the contiguous subarray 
        int maxSum = Integer.MIN_VALUE;
        
        // the maximum sum of the contiguous subarray till that point
        int maxCurrent = 0;
        
        for(int num : nums) {
            // sum after including the current number
            int currentSum = num + maxCurrent;
            
            // check if the number alone is good enough 
            maxCurrent = Math.max(num, currentSum);
            
            // update the maximum sum
            maxSum = Math.max(maxSum, maxCurrent);
        }
        
        return maxSum;
    }
}

/*
Time complexity: O(n)
Space complexity: O(1)
*/
