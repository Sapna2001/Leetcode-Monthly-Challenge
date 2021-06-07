/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3770/
*/

class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        return Math.min(minCost(cost,cost.length - 1), minCost(cost,cost.length - 2));   
    }
    
    private int minCost(int[] cost, int n) {
        if(n < 0)
            return 0;
        if(n == 0 || n== 1)
            return cost[n];
        if(dp[n] != 0)
            return dp[n];   
        dp[n] = cost[n]+Math.min(minCost(cost,n-1),minCost(cost,n-2));
        return dp[n];
    }
}
