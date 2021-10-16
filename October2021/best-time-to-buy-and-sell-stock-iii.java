/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfitSoldToday = 0, leastSoFar = prices[0];
        int[] maxProfitIfSoldUptoToday = new int[n];
        
        for(int i = 1 ; i < n ; i++) {
            leastSoFar = Math.min(leastSoFar, prices[i]);
            maxProfitSoldToday = prices[i] - leastSoFar;
            
            if(maxProfitSoldToday > maxProfitIfSoldUptoToday [i - 1]) {
                maxProfitIfSoldUptoToday[i] = maxProfitSoldToday;
            } else {
                maxProfitIfSoldUptoToday[i] = maxProfitIfSoldUptoToday[i - 1];    
            }
        }
        
        int maxProfitBroughtToday = 0, maxAfterToday = prices[n -1];
        // bought today or after
        int[] maxProfitBrought = new int[n];
        
        for(int i = n - 2 ; i >= 0 ; i--) {
            maxAfterToday = Math.max(maxAfterToday, prices[i]);
            maxProfitBroughtToday = maxAfterToday - prices[i];
            
            if(maxProfitBroughtToday > maxProfitBrought[i + 1]) {
                maxProfitBrought[i] = maxProfitBroughtToday;
            } else {
                maxProfitBrought[i] = maxProfitBrought[i + 1];    
            }
        }
        
        int overAllProfit = 0;
        for(int i = 0 ; i < n ; i++) {
            overAllProfit = Math.max(overAllProfit, maxProfitIfSoldUptoToday[i] + maxProfitBrought[i]);
        }    
        
        return overAllProfit;
    }
}
