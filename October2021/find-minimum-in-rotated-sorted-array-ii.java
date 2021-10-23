/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
*/

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
		int high = nums.length - 1;
        
		while(low < high){
			int mid = low + ( high - low) / 2;
            
			if(nums[high] == nums[mid]) {
				high = high - 1;
			}
			else if(nums[high] > nums[mid]){
				high = mid;
			} else{
				low = mid + 1;
			}
		}
        
		return nums[low];   
    }
}
