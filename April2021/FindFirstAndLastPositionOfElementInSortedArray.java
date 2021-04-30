/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Link: https://leetcode.com/explore/challenge/card/april-leetcoding-challenge-2021/597/week-5-april-29th-april-30th/3725/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = -1 , right = -1;
        int foundIndex = search(nums, target);
        if(foundIndex == -1) 
            return new int[]{left, right};
        int i = foundIndex;
        while(i >= 0 && nums[i] == target){
            left = i;
            i--;
        }
        i = foundIndex;
        while(i < nums.length && nums[i] == target){
            right = i;
            i++;
        }
        return new int[]{left, right};
    }
    
    public int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else if(nums[mid] > target)
                right = mid - 1;
        }
        
        return -1;
    }
}

//TC: O(logn)
// Binary Search used
