/*
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Link: https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/
*/

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        if(nums.length < 3)
            return count;
        for(int i = 2; i < nums.length ; i++) {
            int left = 0, right = i - 1;
            while(left < right) {
                if(nums[left]+nums[right] > nums[i]) {
                    count += (right - left);
                    right--;
                } else
                    left++;
            }
        }
        return count;
    }
}

// TC: O(n^2)
// SC: O(1)
