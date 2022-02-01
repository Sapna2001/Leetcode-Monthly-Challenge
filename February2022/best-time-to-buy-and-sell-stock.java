/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, cheapest = prices[0];
        for(int i = 1 ; i < prices.length ; i++) {
            if(prices[i] > cheapest) {
                int profit = prices[i] - cheapest;
                maxProfit = Math.max(profit, maxProfit);
            }
            
            cheapest = Math.min(prices[i], cheapest);
        }
        
        return maxProfit;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
