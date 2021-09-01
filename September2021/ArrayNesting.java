/*
You are given an integer array nums of length n where nums is a permutation of the numbers in the range [0, n - 1].

You should build a set s[k] = {nums[k], nums[nums[k]], nums[nums[nums[k]]], ... } subjected to the following rule:

The first element in s[k] starts with the selection of the element nums[k] of index = k.
The next element in s[k] should be nums[nums[k]], and then nums[nums[nums[k]]], and so on.
We stop adding right before a duplicate element occurs in s[k].
Return the longest length of a set s[k].

Link: https://leetcode.com/explore/featured/card/september-leetcoding-challenge-2021/636/week-1-september-1st-september-7th/3960/
*/

class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] < 0)
                continue;
            
            maxLength = Math.max(maxLength, calculateLength(nums, i));
        }
        
        return maxLength;
    }
    
    private int calculateLength(int[] nums, int index) {
        if(index < 0 || nums[index] < 0 || index >= nums.length) 
            return 0;
        
        int nextValue = nums[index];
        nums[index] = Integer.MIN_VALUE;
        
        return 1 + calculateLength(nums, nextValue);
    }
}

/*
TC: O(n)
SC: O(1)
*/
