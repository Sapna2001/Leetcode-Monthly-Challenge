/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. 
You may assume that each input would have exactly one solution.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/611/week-4-july-22nd-july-28th/3828/

TC: O(n^2)
SC: O(1)
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[nums.length - 1];
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int currentSum = nums[i] + nums[start] + nums[end];
                if(currentSum > target)
                    end--;
                else
                    start++;
                if(Math.abs(currentSum - target) < Math.abs(closestSum - target))
                    closestSum = currentSum;
            }
        }
        return closestSum;
    }
}
