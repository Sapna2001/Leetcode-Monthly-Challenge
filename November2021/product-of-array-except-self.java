/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Link: https://leetcode.com/problems/product-of-array-except-self/
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        result[0] = 1;
        
        for(int i = 1 ; i < nums.length ; i++) {
            int previousIndex = i - 1;
            result[i] = result[previousIndex] * nums[previousIndex];
        }
        
        int rightSideProduct = 1;
        
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            result[i] = result[i] * rightSideProduct;
            rightSideProduct *= nums[i];
        }
        
        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/
