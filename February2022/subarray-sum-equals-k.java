/*
Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

Link: https://leetcode.com/problems/subarray-sum-equals-k/
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, sum = 0;
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        hashmap.put(0,1);
        
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            Integer required = sum - k;
            boolean suitableSum = hashmap.containsKey(required);
            if(suitableSum) {
                result += hashmap.get(required);
            }
            
            Integer frequency = hashmap.getOrDefault(sum, 0) + 1;
            hashmap.put(sum, frequency);
        }
        
        return result;
    }
}

/*
Time complexity: O(n)
Space complexity: O(n)
*/
