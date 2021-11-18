/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int index = -1;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] < 0) {
                index = -nums[i] - 1;
            } else {
                index = nums[i] - 1;    
            }
            
            if(nums[index] > 0) {
                nums[index] = - nums[index];
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
