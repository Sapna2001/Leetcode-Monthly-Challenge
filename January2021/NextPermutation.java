/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

Link - https://leetcode.com/explore/featured/card/january-leetcoding-challenge-2021/583/week-5-january-29th-january-31st/3623/
*/

class Solution {
    public void nextPermutation(int[] nums) {
       int i = nums.length - 2;
		while(i>=0 && nums[i]>=nums[i+1])
			i--;
		if(i>=0) {
			int j = nums.length - 1;
			while(j>=0 &&nums[i]>=nums[j])
				j--;
			swap(nums,i,j);
		}
		reverse(nums,i+1);
    }
    
    public void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while(i<j) {
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        nums[i] = nums[i]^nums[j];
        nums[j] = nums[i]^nums[j];
        nums[i] = nums[i]^nums[j];
    }
    
}
