/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset 
satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.

Link: https://leetcode.com/problems/largest-divisible-subset/
*/

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] dp = new int[nums.length];
        return getList(nums, dp, constructDP(nums, dp));
    }
    
    private int constructDP(int[] nums, int[] dp) {
        Arrays.sort(nums);
        Arrays.fill(dp, 1);
        int largest = 1;
        
        for(int i =  1; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    largest = Math.max(largest, dp[i]);
                }
            }
        }
        
        return largest;
    }
    
    private List<Integer> getList(int[] nums, int[] dp, int size) {
        int previous = -1;
        LinkedList<Integer> result = new LinkedList<Integer>();
        
        for(int i = dp.length - 1 ; i >= 0 ; i--) {
            if(dp[i] == size && (previous == -1 || previous % nums[i] == 0)) {
                result.addFirst(nums[i]);
                size--;
                previous = nums[i];
            }    
        }
        
        return result;
    }
}
