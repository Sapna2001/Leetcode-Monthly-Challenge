/*

Given an integer array nums, return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.

Link: https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
*/

class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0, mask = 0;
        for(int i = 31 ; i >= 0 ; i--) {
            mask = mask | (1<<i);
            Set<Integer> set = new HashSet<Integer>();
            
            for(int num : nums) {
                set.add(num & mask);
            }
            
            int temp = maxXor | (1<<i);
            
            for(int prefix : set) {
                if(set.contains(temp ^ prefix)) {
                    maxXor = temp;
                    break;
                }    
            }
        }
        
        return maxXor;
    }
}

/*
Time Complexity: O(32 * n)
Space Complexity: O(n)
*/

