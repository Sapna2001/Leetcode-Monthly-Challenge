/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately 
sell it on the same day.

Find and return the maximum profit you can achieve.

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, valley = prices[0], peak = prices[0], profit = 0;
        while( i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i+1])
                i++;
            valley = prices[i];
            
            while(i < prices.length - 1 && prices[i+1] >= prices[i])
                i++;
            peak = prices[i];
            
            profit += peak - valley;
        }
        return profit;
    }
}

