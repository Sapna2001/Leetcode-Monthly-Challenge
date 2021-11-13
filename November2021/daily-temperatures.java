/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after 
the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Link: https://leetcode.com/problems/daily-temperatures/
*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int maxTemp = Integer.MIN_VALUE;
        int[] result = new int[temperatures.length];
        
        for(int i = temperatures.length - 1 ; i >= 0 ; i--) {
            int currentTemp = temperatures[i];
            if(currentTemp >= maxTemp) {
                maxTemp = currentTemp;
                continue;
            }
            
            int daysCount = 1;
            while(temperatures[i + daysCount] <= currentTemp) {
                daysCount += result[i + daysCount];   
            }
            
            result[i] = daysCount;
        }
        
        return result;
    }
}
