/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + 
nums[right]).

Link: https://leetcode.com/explore/challenge/card/august-leetcoding-challenge-2021/615/week-3-august-15th-august-21st/3892/

TC: O(n)
SC: O(n)
*/

class NumArray {
    int[] prefixSum;
    
    public NumArray(int[] nums) {
        prefixSum = nums;
        for(int i = 1 ; i < nums.length ; i++)
            prefixSum[i] += prefixSum[i-1];
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) 
            return prefixSum[right];
        return prefixSum[right] - prefixSum[left-1];
    }
}
