/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the 
same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Link: https://leetcode.com/problems/house-robber/
*/

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        
        // if only 1 house present
        if(length == 1) {
            return nums[0];
        };
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        // check if it is beneficial to rob house1 or house2
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2 ; i < length ; i++) {
            // previous robbed house when the current house is robbed
            int previousRobbedCurrent = i - 2;
            
            // amount when the current house is robbed
            int amountRobbedCurrent = dp[previousRobbedCurrent] + nums[i];
            
            // previous robbed house when the current house is not robbed
            int previousNotRobbed = i - 1;
            
            // amount when the current house is not robbed
            int amountNotRobbed = dp[previousNotRobbed];
            
            // check if it is beneficial to rob the current house or the previous house
            dp[i] = Math.max(amountNotRobbed, amountRobbedCurrent);
        }
        
        return dp[length - 1];
    }
}

/*
Time complexity: O(N)
Space complexity: O(N)
*/

