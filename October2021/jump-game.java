/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Link: https://leetcode.com/problems/jump-game/
*/

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) 
            return true;
        
        int i = 0, reach = nums[0];
        
        while(reach >= i) {
            if(reach >= nums.length -1)
                return true;
            reach = Math.max(reach, nums[i] + i);
            i++;
        }
        
        return false;
    }
}
