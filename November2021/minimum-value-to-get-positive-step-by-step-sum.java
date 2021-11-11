/*
Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

Link: https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
*/

class Solution {
    public int minStartValue(int[] nums) {
        int minVal = Integer.MAX_VALUE, total = 0;
        for(int i : nums) {
            total += i;
            minVal = Math.min(minVal, total);
        }
        
        return minVal < 0 ? Math.abs(minVal) + 1 : 1;
    }
}
