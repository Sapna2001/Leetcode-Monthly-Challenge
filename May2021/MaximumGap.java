/*
Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If the array contains less than two elements, return 0.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3761/
*/

class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int maximum = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++)
            maximum = Math.max(maximum,Math.abs(nums[i]-nums[i+1]));
        return maximum;
    }
}

//TC:O(nlogn)
