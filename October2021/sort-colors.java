/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order 
red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Link: https://leetcode.com/problems/sort-colors/
*/

class Solution {
    public void sortColors(int[] nums) {
        int left= 0,right = nums.length-1,i = 0;
        
        while(i < nums.length &&  i <= right) {
            if(nums[i] == 0) {
                swap(nums,left,i);
                left++;
                i++;
            } else if(nums[i] == 2) {
                swap(nums,right,i);
                right--;
            } else {
                i++;
            }
        }
    }
    
   private void swap(int arr[],int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;  
    }
}
