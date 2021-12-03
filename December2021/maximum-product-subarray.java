/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Link: https://leetcode.com/problems/maximum-product-subarray/
*/

class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct = nums[0], minProduct = nums[0], ans = nums[0], result = nums[0];
        for(int i = 1 ; i < nums.length ; i++) {
            // Store previous values
            int previousMaxProduct = maxProduct, previousMinProduct = minProduct;
            
            // Product when max is considered
            int productWithMax = previousMaxProduct * nums[i];
            
            // Product when min is considered
            int productWithMin = previousMinProduct * nums[i];
            
            // Update the values
            maxProduct = Math.max(nums[i], Math.max(productWithMax, productWithMin));
            minProduct = Math.min(nums[i], Math.min(productWithMax, productWithMin));
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/
