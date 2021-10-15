/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*/

class Solution {
    public int maxProfit(int[] prices) {
        int buyStateProfit = -prices[0], sellStateProfit = 0, coolStateProfit = 0;    
        
        for(int i = 1 ; i < prices.length ; i++) {
            int newBuyStateProfit = 0, newSellStateProfit = 0, newCoolStateProfit = 0;
            
            newBuyStateProfit = Math.max(buyStateProfit, coolStateProfit - prices[i]);
            
            newSellStateProfit = Math.max(sellStateProfit, prices[i] + buyStateProfit);
            
            newCoolStateProfit = Math.max(coolStateProfit, sellStateProfit);
            
            buyStateProfit = newBuyStateProfit;
            sellStateProfit = newSellStateProfit;
            coolStateProfit = newCoolStateProfit;
        }
        
        return sellStateProfit;
    }
}
