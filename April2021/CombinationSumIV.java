/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/595/week-3-april-15th-april-21st/3713/
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        int dp[]=new int[target+1];
        dp[0]=1;
        for(int i = 0; i <= target; i++){
            for(int num:nums)
                if(i + num <= target)
                    dp[i+num]+=dp[i];
        }
        return dp[target];
    }
}
