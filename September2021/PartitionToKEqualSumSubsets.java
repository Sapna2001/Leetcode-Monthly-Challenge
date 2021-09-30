/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Link: https://leetcode.com/explore/challenge/card/september-leetcoding-challenge-2021/640/week-5-september-29th-september-30th/3993/
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;
        for(int i : nums)
            total += i;
        
        if(total % k != 0 || nums.length < k)
            return false;
        
        int subsetSum = total / k;
        boolean[] visited = new boolean[nums.length];
        
        return partitionPossible(nums,visited,0,k,0,subsetSum);
    }
    
    private boolean partitionPossible (int[] nums, boolean[] visited, int start, int k, int currentSum, int subsetSum) {
        if(k == 0)
            return true;
        
        if(currentSum > subsetSum)
            return false;
        
        if(subsetSum == currentSum)
            return partitionPossible(nums,visited,0,k-1,0,subsetSum);
        
        for(int i = start ; i < nums.length ; i++) {
            if(visited[i])
                continue;
            
            visited[i] = true;
            
            if(partitionPossible(nums,visited,i+1,k,currentSum + nums[i],subsetSum))
                return true;
            
            visited[i] = false;
        }
        
        return false;
    }
}
