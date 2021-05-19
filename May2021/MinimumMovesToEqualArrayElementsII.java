/*
Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

In one move, you can increment or decrement an element of the array by 1.

Link: https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/600/week-3-may-15th-may-21st/3748/
*/

class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int median = nums[nums.length / 2];
        for(int num : nums) 
            count += Math.abs(num - median);
        return count;
    }
}

/*
TC : O(nlogn)
SC : O(1)
*/
